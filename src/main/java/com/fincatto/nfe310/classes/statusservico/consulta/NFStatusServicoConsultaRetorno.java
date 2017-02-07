package com.fincatto.nfe310.classes.statusservico.consulta;

import org.joda.time.LocalDateTime;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.dfe.classes.DFAmbiente;
import com.fincatto.dfe.classes.DFUnidadeFederativa;
import com.fincatto.dfe.classes.statusservico.consulta.IStatusServicoConsultaRetorno;
import com.fincatto.dfe.transformers.DFLocalDateTimeTransformer;
import com.fincatto.nfe310.classes.NFBase;

@Root(name = "retConsStatServ")
@Namespace(reference = "http://www.portalfiscal.inf.br/nfe")
public class NFStatusServicoConsultaRetorno extends NFBase implements IStatusServicoConsultaRetorno {

    @Attribute(name = "versao")
    private String versao;

    @Element(name = "tpAmb")
    private DFAmbiente ambiente;

    @Element(name = "verAplic")
    private String versaoAplicacao;

    @Element(name = "cStat")
    private String status;

    @Element(name = "xMotivo")
    private String motivo;

    @Element(name = "cUF")
    private DFUnidadeFederativa uf;

    @Element(name = "dhRecbto")
    private LocalDateTime dataRecebimento;

    @Element(name = "tMed", required = false)
    private String tempoMedio;

    @Element(name = "dhRetorno", required = false)
    private LocalDateTime dataRetorno;

    @Element(name = "xObs", required = false)
    private String observacao;

    public NFStatusServicoConsultaRetorno() {
        this.versao = null;
        this.ambiente = null;
        this.versaoAplicacao = null;
        this.status = null;
        this.motivo = null;
        this.uf = null;
        this.dataRecebimento = null;
        this.tempoMedio = null;
        this.dataRetorno = null;
        this.observacao = null;
    }

    @Override
    public String getVersao() {
        return this.versao;
    }

    public void setVersao(final String versao) {
        this.versao = versao;
    }

    @Override
    public DFAmbiente getAmbiente() {
        return this.ambiente;
    }

    public void setAmbiente(final DFAmbiente ambiente) {
        this.ambiente = ambiente;
    }

    @Override
    public String getVersaoAplicacao() {
        return this.versaoAplicacao;
    }

    public void setVersaoAplicacao(final String versaoAplicacao) {
        this.versaoAplicacao = versaoAplicacao;
    }

    @Override
    public String getStatus() {
        return this.status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    @Override
    public String getMotivo() {
        return this.motivo;
    }

    public void setMotivo(final String motivo) {
        this.motivo = motivo;
    }

    @Override
    public DFUnidadeFederativa getUf() {
        return this.uf;
    }

    public void setUf(final DFUnidadeFederativa uf) {
        this.uf = uf;
    }

    public LocalDateTime getDataRecebimento() {
        return this.dataRecebimento;
    }

    public void setDataRecebimento(final LocalDateTime dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    @Override
    public String getTempoMedio() {
        return this.tempoMedio;
    }

    public void setTempoMedio(final String tempoMedio) {
        this.tempoMedio = tempoMedio;
    }

    public LocalDateTime getDataRetorno() {
        return this.dataRetorno;
    }

    public void setDataRetorno(final LocalDateTime dataRetorno) {
        this.dataRetorno = dataRetorno;
    }

    @Override
    public String getObservacao() {
        return this.observacao;
    }

    public void setObservacao(final String observacao) {
        this.observacao = observacao;
    }

	@Override
	public String getDataRecebimentoString() {
		try {
			return new DFLocalDateTimeTransformer().write(getDataRecebimento());
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public String getDataRetornoString() {
		try {
			return new DFLocalDateTimeTransformer().write(getDataRetorno());
		} catch (Exception e) {
		}
		return null;
	}
}