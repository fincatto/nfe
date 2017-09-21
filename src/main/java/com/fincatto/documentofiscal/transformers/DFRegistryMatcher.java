package com.fincatto.documentofiscal.transformers;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.simpleframework.xml.transform.RegistryMatcher;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.cte200.classes.*;
import com.fincatto.documentofiscal.cte200.transformers.*;
import com.fincatto.documentofiscal.nfe310.classes.*;
import com.fincatto.documentofiscal.nfe310.classes.cadastro.NFIndicadorContribuinteCTe;
import com.fincatto.documentofiscal.nfe310.classes.cadastro.NFIndicadorContribuinteNFe;
import com.fincatto.documentofiscal.nfe310.classes.cadastro.NFSituacaoContribuinte;
import com.fincatto.documentofiscal.nfe310.classes.lote.envio.NFLoteIndicadorProcessamento;
import com.fincatto.documentofiscal.nfe310.classes.nota.*;
import com.fincatto.documentofiscal.nfe310.transformers.*;

public class DFRegistryMatcher extends RegistryMatcher {

    public DFRegistryMatcher() {
        super.bind(NFTipo.class, new NFTipoTransformer());
        super.bind(DFModelo.class, new DFModeloTransformer());
        super.bind(NFOrigem.class, new NFOrigemTransformer());
        super.bind(DFAmbiente.class, new DFAmbienteTransformer());
        super.bind(LocalDate.class, new DFLocalDateTransformer());
        super.bind(LocalTime.class, new DFLocalTimeTransformer());
        super.bind(NFFinalidade.class, new NFFinalidadeTransformer());
        super.bind(NFTipoEmissao.class, new NFTipoEmissaoTransformer());
        super.bind(DateTime.class, new DFDateTimeTransformer());
        super.bind(LocalDateTime.class, new DFLocalDateTimeTransformer());
        super.bind(NFTipoImpressao.class, new NFTipoImpressaoTransformer());
        super.bind(NFOrigemProcesso.class, new NFOrigemProcessoTransformer());
        super.bind(NFOperadoraCartao.class, new NFOperadoraCartaoTransformer());
        super.bind(NFProcessoEmissor.class, new NFProgramaEmissorTransformer());
        super.bind(NFModalidadeFrete.class, new NFModalidadeFreteTransformer());
        super.bind(NFRegimeTributario.class, new NFRegimeTributarioTransformer());
        super.bind(NFFormaPagamentoPrazo.class, new NFFormaPagamentoTransformer());
        super.bind(DFUnidadeFederativa.class, new DFUnidadeFederativaTransformer());
        super.bind(NFNotaInfoVeiculoCor.class, new NFNotaInfoVeiculoCorTransformer());
        super.bind(NFFormaPagamentoMoeda.class, new NFFormaPagamentoMoedaTransformer());
        super.bind(NFNotaInfoTipoVeiculo.class, new NFNotaInfoTipoVeiculoTransformer());
        super.bind(NFSituacaoContribuinte.class, new NFSituacaoContribuinteTransformer());
        super.bind(NFNotaInfoEspecieVeiculo.class, new NFNotaInfoEspecieVeiculoTransformer());
        super.bind(NFProdutoCompoeValorNota.class, new NFProdutoCompoeValorNotaTransformer());
        super.bind(NFTipoIntegracaoPagamento.class, new NFTipoIntegracaoPagamentoTransformer());
        super.bind(NFIndicadorIEDestinatario.class, new NFIndicadorIEDestinatarioTransformer());
        super.bind(NFOperacaoConsumidorFinal.class, new NFOperacaoConsumidorFinalTransformer());
        super.bind(NFNotaInfoCombustivelTipo.class, new NFNotaInfoCombustivelTipoTransformer());
        super.bind(NFIndicadorContribuinteCTe.class, new NFIndicadorContribuinteCTTransformer());
        super.bind(NFIndicadorContribuinteNFe.class, new NFIndicadorContribuinteNFeTransformer());
        super.bind(NFNotaMotivoDesoneracaoICMS.class, new NFNotaMotivoDesoneracaoICMSTransformer());
        super.bind(NFLoteIndicadorProcessamento.class, new NFLoteIndicadorProcessamentoTransformer());
        super.bind(NFViaTransporteInternacional.class, new NFViaTransporteInternacionalTransformer());
        super.bind(NFIndicadorPresencaComprador.class, new NFIndicadorPresencaCompradorTransformer());
        super.bind(NFFormaImportacaoIntermediacao.class, new NFFormaImportacaoIntermediacaoTransformer());
        super.bind(NFNotaInfoImpostoTributacaoICMS.class, new NFNotaInfoImpostoTributacaoICMSTransformer());
        super.bind(NFNotaInfoSituacaoTributariaIPI.class, new NFNotaInfoSituacaoTributariaIPITransformer());
        super.bind(NFNotaInfoSituacaoTributariaPIS.class, new NFNotaInfoSituacaoTributariaPISTransformer());
        super.bind(NFNotaInfoItemModalidadeBCICMSST.class, new NFnotaInfoItemModalidadeBCICMSSTTransformer());
        super.bind(NFNotaInfoRegimeEspecialTributacao.class, new NFNotaInfoRegimeEspecialTributacaoTransformer());
        super.bind(NFNotaInfoSituacaoTributariaCOFINS.class, new NFNotaInfoSituacaoTributariaCOFINSTransformer());
        super.bind(NFNotaInfoItemProdutoArmamentoTipo.class, new NFNotaInfoItemProdutoArmamentoTipoTransformer());
        super.bind(NFIdentificadorLocalDestinoOperacao.class, new NFIdentificadorLocalDestinoOperacaoTransformer());
        super.bind(NFNotaInfoItemProdutoVeiculoCondicao.class, new NFNotaInfoItemProdutoVeiculoCondicaoTransformer());
        super.bind(NFNotaInfoItemProdutoVeiculoRestricao.class, new NFNotaInfoItemProdutoVeiculoRestricaoTransformer());
        super.bind(NFNotaInfoItemIndicadorIncentivoFiscal.class, new NFNotaInfoItemIndicadorIncentivoFiscalTransformer());
        super.bind(NFNotaInfoItemIndicadorExigibilidadeISS.class, new NFNotaInfoItemIndicadorExigibilidadeISSTransformer());
        super.bind(NFNotaSituacaoOperacionalSimplesNacional.class, new NFNotaSituacaoOperacionalSimplesNacionalTransformer());
        super.bind(NFNotaInfoItemProdutoVeiculoTipoOperacao.class, new NFNotaInfoItemProdutoVeiculoTipoOperacaoTransformer());
        super.bind(NFNotaInfoItemProdutoVeiculoCondicaoChassi.class, new NFNotaInfoItemProdutoVeiculoCondicaoChassiTransformer());
        super.bind(NFNotaInfoItemModalidadeBCICMS.class, new NFNotaInfoItemModalidadeBCICMSTransformer());
        // CTe
        super.bind(CTModal.class, new CTModalTransformer());
        super.bind(CTTipoCte.class, new CTTipoCteTransformer());
        super.bind(CTTipoServico.class, new CTTipoServicoTransformer());
        super.bind(CTTipoEmissao.class, new CTTipoEmissaoTransformer());
        super.bind(CTUnidadeMedida.class, new CTUnidadeMedidaTransformer());
        super.bind(CTTipoImpressao.class, new CTTipoImpressaoTransformer());
        super.bind(CTFormaPagamento.class, new CTFormaPagamentoTransformer());
        super.bind(CTTomadorServico.class, new CTTomadorServicoTransformer());
        super.bind(CTTipoEntregaData.class, new CTTipoEntregaDataTransformer());
        super.bind(CTRetiraMercadoria.class, new CTRetiraMercadoriaTransformer());
        super.bind(CTTipoUnidadeCarga.class, new CTTipoUnidadeCargaTransformer());
        super.bind(CTResponsavelSeguro.class, new CTResponsavelSeguroTransformer());
        super.bind(CTTipoDocumentoOutro.class, new CTTipoDocumentoOutroTransformer());
        super.bind(CTTipoEntregaHorario.class, new CTTipoEntregaHorarioTransformer());
        super.bind(CTIdentificadorEmissor.class, new CTIdentificadorEmissorTransformer());
        super.bind(CTTipoUnidadeTransporte.class, new CTTipoUnidadeTransporteTransformer());
        super.bind(CTTipoDocumentoTransporteAnterior.class, new CTTipoDocumentoTransporteAnteriorTransformer());

    }
}