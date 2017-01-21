package com.fincatto.dfe.webservices;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Enumeration;

import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509KeyManager;

import org.apache.commons.httpclient.params.HttpConnectionParams;
import org.apache.commons.httpclient.protocol.ProtocolSocketFactory;

import com.fincatto.dfe.DFeConfig;

public class DFSocketFactory implements ProtocolSocketFactory {

    private final DFeConfig config;
    private final SSLContext context;

    public DFSocketFactory(final DFeConfig config) throws CertificateException, UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException, IOException {
        this.config = config;
        this.context = createSSLContext(config);
    }

    @Override
    public Socket createSocket(final String host, final int port, final InetAddress localAddress, final int localPort, final HttpConnectionParams params) throws IOException {
        final Socket socket = this.context.getSocketFactory().createSocket();
        ((SSLSocket) socket).setEnabledProtocols(new String[] {config.getSSLProtocolo()});
        socket.bind(new InetSocketAddress(localAddress, localPort));
        socket.connect(new InetSocketAddress(host, port), 60000);
        return socket;
    }

    @Override
    public Socket createSocket(final String host, final int port, final InetAddress clientHost, final int clientPort) throws IOException {
        return this.context.getSocketFactory().createSocket(host, port, clientHost, clientPort);
    }

    @Override
    public Socket createSocket(final String host, final int port) throws IOException {
        return this.context.getSocketFactory().createSocket(host, port);
    }

    private static SSLContext createSSLContext(final DFeConfig config) throws UnrecoverableKeyException, CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException, KeyManagementException {
        final KeyManager[] keyManagers = createKeyManagers(config);
        final TrustManager[] trustManagers = createTrustManagers(config);
        final SSLContext sslContext = SSLContext.getInstance(config.getSSLProtocolo());
        sslContext.init(keyManagers, trustManagers, null);
        return sslContext;
    }

    private static KeyManager[] createKeyManagers(final DFeConfig config) throws UnrecoverableKeyException, KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException {
        final String alias = getAlias(config.getCertificadoKeyStore());
        final X509Certificate certificate = (X509Certificate) config.getCertificadoKeyStore().getCertificate(alias);
        final PrivateKey privateKey = (PrivateKey) config.getCertificadoKeyStore().getKey(alias, config.getCertificadoSenha().toCharArray());
        return new KeyManager[]{new NFKeyManager(certificate, privateKey)};
    }

    private static TrustManager[] createTrustManagers(final DFeConfig config) throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException {
        final TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(config.getCadeiaCertificadosKeyStore());
        return trustManagerFactory.getTrustManagers();
    }

    private static String getAlias(final KeyStore ks) throws KeyStoreException {
        final Enumeration<String> aliasesEnum = ks.aliases();
        while (aliasesEnum.hasMoreElements()) {
            final String alias = aliasesEnum.nextElement();
            if (ks.isKeyEntry(alias)) {
                return alias;
            }
        }
        throw new KeyStoreException("Nenhum alias encontrado no certificado");
    }
}

class NFKeyManager implements X509KeyManager {

    private final X509Certificate certificate;
    private final PrivateKey privateKey;

    NFKeyManager(final X509Certificate certificate, final PrivateKey privateKey) {
        this.certificate = certificate;
        this.privateKey = privateKey;
    }

    @Override
    public String chooseClientAlias(final String[] arg0, final Principal[] arg1, final Socket arg2) {
        return this.certificate.getIssuerDN().getName();
    }

    @Override
    public String chooseServerAlias(final String arg0, final Principal[] arg1, final Socket arg2) {
        return null;
    }

    @Override
    public X509Certificate[] getCertificateChain(final String arg0) {
        return new X509Certificate[]{this.certificate};
    }

    @Override
    public String[] getClientAliases(final String arg0, final Principal[] arg1) {
        return new String[]{this.certificate.getIssuerDN().getName()};
    }

    @Override
    public PrivateKey getPrivateKey(final String arg0) {
        return this.privateKey;
    }

    @Override
    public String[] getServerAliases(final String arg0, final Principal[] arg1) {
        return null;
    }
}