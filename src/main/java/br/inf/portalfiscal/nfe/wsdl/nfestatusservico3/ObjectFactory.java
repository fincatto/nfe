
package br.inf.portalfiscal.nfe.wsdl.nfestatusservico3;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.inf.portalfiscal.nfe.wsdl.nfestatusservico3 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _NfeCabecMsg_QNAME = new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NfeStatusServico3", "nfeCabecMsg");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.inf.portalfiscal.nfe.wsdl.nfestatusservico3
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link NfeCabecMsg }
     * 
     */
    public NfeCabecMsg createNfeCabecMsg() {
        return new NfeCabecMsg();
    }

    /**
     * Create an instance of {@link NfeDadosMsg }
     * 
     */
    public NfeDadosMsg createNfeDadosMsg() {
        return new NfeDadosMsg();
    }

    /**
     * Create an instance of {@link NfeStatusServicoNFResult }
     * 
     */
    public NfeStatusServicoNFResult createNfeStatusServicoNFResult() {
        return new NfeStatusServicoNFResult();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NfeCabecMsg }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NfeStatusServico3", name = "nfeCabecMsg")
    public JAXBElement<NfeCabecMsg> createNfeCabecMsg(NfeCabecMsg value) {
        return new JAXBElement<NfeCabecMsg>(_NfeCabecMsg_QNAME, NfeCabecMsg.class, null, value);
    }

}
