package com.fincatto.documentofiscal.cte200.classes.cte;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;

@Root(name = "idDocAntEle")
public class CTInfoDocumentoAnteriorEletronico extends DFBase {

    @Element(name = "chave")
    private String chaveCte;

    public String getChaveCte() {
        return this.chaveCte;
    }

    public void setChaveCte(final String chaveCte) {
        this.chaveCte = chaveCte;
    }

}
