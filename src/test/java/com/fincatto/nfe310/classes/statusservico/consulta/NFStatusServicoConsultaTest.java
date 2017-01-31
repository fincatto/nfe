package com.fincatto.nfe310.classes.statusservico.consulta;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.dfe.classes.DFAmbiente;
import com.fincatto.dfe.classes.DFUnidadeFederativa;
import com.fincatto.nfe310.FabricaDeObjetosFakeNFe;

public class NFStatusServicoConsultaTest {

    @Test
    public void deveObterVersaoComoFoiSetado() {
        final NFStatusServicoConsulta servicoConsulta = new NFStatusServicoConsulta();
        final String versao = "3.10";
        servicoConsulta.setVersao(versao);
        Assert.assertEquals(versao, servicoConsulta.getVersao());
    }

    @Test
    public void deveObterAmbienteComoFoiSetado() {
        final NFStatusServicoConsulta servicoConsulta = new NFStatusServicoConsulta();
        final DFAmbiente ambiente = DFAmbiente.HOMOLOGACAO;
        servicoConsulta.setAmbiente(ambiente);
        Assert.assertEquals(ambiente, servicoConsulta.getAmbiente());
    }

    @Test
    public void deveObterUFComoFoiSetado() {
        final NFStatusServicoConsulta servicoConsulta = new NFStatusServicoConsulta();
        final DFUnidadeFederativa unidadeFederativa = DFUnidadeFederativa.SP;
        servicoConsulta.setUf(unidadeFederativa);
        Assert.assertEquals(unidadeFederativa, servicoConsulta.getUf());
    }

    @Test
    public void deveObterServicoComoFoiSetado() {
        final NFStatusServicoConsulta servicoConsulta = new NFStatusServicoConsulta();
        final String servico = "STATUS";
        servicoConsulta.setServico(servico);
        Assert.assertEquals(servico, servicoConsulta.getServico());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<consStatServ versao=\"3.10\" xmlns=\"http://www.portalfiscal.inf.br/nfe\"><tpAmb>1</tpAmb><cUF>52</cUF><xServ>STATUS</xServ></consStatServ>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFakeNFe.getNFStatusServicoConsulta().toString());
    }
}