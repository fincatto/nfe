package com.fincatto.nfe310.classes.nota;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.dfe.classes.DFAmbiente;
import com.fincatto.dfe.classes.DFUnidadeFederativa;
import com.fincatto.dfe.classes.DFTipoEmissao;
import com.fincatto.nfe310.FabricaDeObjetosFake;
import com.fincatto.nfe310.NFeConfig;
import com.fincatto.nfe310.utils.NFGeraQRCode;

public class NFGeraQRCodeTest {

    //EXEMPLO DO MANUAL DA RECEITA
    public static final String URL_TEST = "?chNFe=28140300156225000131650110000151341562040824&nVersao=100&tpAmb=1&cDest=13017959000181&dhEmi=323031342d30332d31385431303a35353a33332d30333a3030&vNF=60.90&vICMS=12.75&digVal=797a4759685578312f5859597a6b7357422b6650523351633530633d&cIdToken=000001&cHashQRCode=329f9d7b9fc5650372c1b2699ab88e9e22e0d33a";

    @Test
    public void geraQRCodeConformeEsperado() throws NoSuchAlgorithmException {

        final NFNota nota = FabricaDeObjetosFake.getNotaQRCode();

        final NFGeraQRCode qr = new NFGeraQRCode(nota, this.createConfigTest());
        final String qrCode = qr.getQRCode();

        nota.setInfoSuplementar(new NFNotaInfoSuplementar());
        nota.getInfoSuplementar().setQrCode(qrCode);

        final String urlUf = nota.getInfo().getIdentificacao().getUf().getQrCodeProducao();
        Assert.assertEquals(urlUf + NFGeraQRCodeTest.URL_TEST, nota.getInfoSuplementar().getQrCode());
    }

    @Test
    public void geraSHA1() throws Exception {
        final String entrada = "chNFe=28140300156225000131650110000151341562040824&nVersao=100&tpAmb=1&cDest=13017959000181&dhEmi=323031342d30332d31385431303a35353a33332d30333a3030&vNF=60.90&vICMS=12.75&digVal=797a4759685578312f5859597a6b7357422b6650523351633530633d&cIdToken=000001SEU-CODIGO-CSC-CONTRIBUINTE-36-CARACTERES";
        final String saida = NFGeraQRCode.sha1(entrada);
        Assert.assertEquals(saida, "329f9d7b9fc5650372c1b2699ab88e9e22e0d33a");
    }

    private NFeConfig createConfigTest() {
        return new NFeConfig() {
            @Override
            public Integer getCodigoSegurancaContribuinteID() {
                return 1;
            }

            @Override
            public String getCodigoSegurancaContribuinte() {
                return "SEU-CODIGO-CSC-CONTRIBUINTE-36-CARACTERES";
            }

            @Override
            public DFUnidadeFederativa getCUF() {
                return DFUnidadeFederativa.SE;
            }

            @Override
            public DFAmbiente getAmbiente() {
                return DFAmbiente.PRODUCAO;
            }

            @Override
            public DFTipoEmissao getTipoEmissao() {
                return null;
            }

            @Override
            public String getSSLProtocolo() {
                return null;
            }

            @Override
            public String getCertificadoSenha() {
                return null;
            }

            @Override
            public byte[] getCertificado() throws IOException {
                return null;
            }

            @Override
            public String getCadeiaCertificadosSenha() {
                return null;
            }

            @Override
            public byte[] getCadeiaCertificados() throws IOException {
                return null;
            }
        };
    }
}