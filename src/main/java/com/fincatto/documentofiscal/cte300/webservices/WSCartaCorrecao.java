package com.fincatto.documentofiscal.cte300.webservices;

import com.fincatto.documentofiscal.cte300.CTeConfig;
import com.fincatto.documentofiscal.cte300.classes.evento.CTeEvento;
import com.fincatto.documentofiscal.cte300.classes.evento.CTeEventoRetorno;
import com.fincatto.documentofiscal.cte300.classes.evento.cartacorrecao.CTeEnviaEventoCartaCorrecao;
import com.fincatto.documentofiscal.cte300.classes.evento.cartacorrecao.CTeInformacaoCartaCorrecao;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import org.apache.axiom.om.OMElement;

import java.math.BigDecimal;
import java.util.List;

class WSCartaCorrecao extends WSRecepcaoEvento {

    private static final String DESCRICAO_EVENTO = "Carta de Correcao";
    private static final BigDecimal VERSAO_LEIAUTE = new BigDecimal("3.00");
    private static final String EVENTO_CARTA_DE_CORRECAO = "110110";

    WSCartaCorrecao(final CTeConfig config) {
        super(config);
    }

    CTeEventoRetorno corrigeNotaAssinada(final String chaveAcesso, final String eventoAssinadoXml) throws Exception {
        final OMElement omElementResult = this.efetuaCorrecao(eventoAssinadoXml, chaveAcesso);
        return this.config.getPersister().read(CTeEventoRetorno.class, omElementResult.toString());
    }

    CTeEventoRetorno corrigeNota(final String chaveAcesso, String grupoAlterado, String campoAlterado, String valorAlterado, Integer numeroItemAlterado, int sequencialEvento) throws Exception {
        final CTeInformacaoCartaCorrecao correcao = new CTeInformacaoCartaCorrecao();
        correcao.setGrupoAlterado(grupoAlterado);
        correcao.setCampoAlterado(campoAlterado);
        correcao.setValorAlterado(valorAlterado);
        correcao.setNumeroItemAlterado(numeroItemAlterado);

        return corrigeNota(chaveAcesso, List.of(correcao), sequencialEvento);
    }

    CTeEventoRetorno corrigeNota(final String chaveAcesso, List<CTeInformacaoCartaCorrecao> correcoes, int sequencialEvento) throws Exception {
        final String xmlAssinado = this.getXmlAssinado(chaveAcesso, correcoes, sequencialEvento);
        final OMElement omElementResult = this.efetuaCorrecao(xmlAssinado, chaveAcesso);
        return this.config.getPersister().read(CTeEventoRetorno.class, omElementResult.toString());
    }

    String getXmlAssinado(final String chave, List<CTeInformacaoCartaCorrecao> correcoes, int sequencialEvento) throws Exception {
        final String xml = this.gerarDadosCartaCorrecao(chave, correcoes, sequencialEvento).toString();
        return new DFAssinaturaDigital(this.config).assinarDocumento(xml);
    }

    private OMElement efetuaCorrecao(final String xmlAssinado, final String chaveAcesso) throws Exception {
        return super.efetuaEvento(xmlAssinado, chaveAcesso, WSCartaCorrecao.VERSAO_LEIAUTE);
    }

    private CTeEvento gerarDadosCartaCorrecao(final String chaveAcesso, List<CTeInformacaoCartaCorrecao> correcoes, int sequencialEvento) {
        final CTeEnviaEventoCartaCorrecao cartaCorrecao = new CTeEnviaEventoCartaCorrecao();
        cartaCorrecao.setDescricaoEvento(WSCartaCorrecao.DESCRICAO_EVENTO);
        cartaCorrecao.setCorrecoes(correcoes);
        cartaCorrecao.setCondicaoUso("A Carta de Correcao e disciplinada pelo Art. 58-B do CONVENIO/SINIEF 06/89: Fica permitida a utilizacao de carta de correcao, para regularizacao de erro ocorrido na emissao de documentos fiscais relativos a prestacao de servico de transporte, desde que o erro nao esteja relacionado com: I - as variaveis que determinam o valor do imposto tais como: base de calculo, aliquota, diferenca de preco, quantidade, valor da prestacao;II - a correcao de dados cadastrais que implique mudanca do emitente, tomador, remetente ou do destinatario;III - a data de emissao ou de saida.");

        return super.gerarEvento(chaveAcesso, WSCartaCorrecao.VERSAO_LEIAUTE, cartaCorrecao, WSCartaCorrecao.EVENTO_CARTA_DE_CORRECAO, null, sequencialEvento);
    }
}
