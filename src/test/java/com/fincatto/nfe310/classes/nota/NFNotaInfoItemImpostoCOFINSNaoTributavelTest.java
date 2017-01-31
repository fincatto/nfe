package com.fincatto.nfe310.classes.nota;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe310.FabricaDeObjetosFakeNFe;
import com.fincatto.nfe310.classes.nota.NFNotaInfoItemImpostoCOFINSNaoTributavel;

public class NFNotaInfoItemImpostoCOFINSNaoTributavelTest {

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirSituacaoTributariaNulo() {
        new NFNotaInfoItemImpostoCOFINSNaoTributavel().toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoCOFINSNaoTributavel><CST>04</CST></NFNotaInfoItemImpostoCOFINSNaoTributavel>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoCOFINSNaoTributavel().toString());
    }
}