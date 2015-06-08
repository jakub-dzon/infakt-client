package org.singularitylab.infakt.client.impl.invoice;

import org.singularitylab.infakt.client.impl.InfaktResponse;
import org.singularitylab.infakt.client.model.Invoice;

import java.util.List;

/**
 * @author Jakub Dzon
 */
class InfaktInvoiceResponse extends InfaktResponse {

    private List<Invoice> entities;

    public List<Invoice> getEntities() {
        return entities;
    }

    public void setEntities(List<Invoice> entities) {
        this.entities = entities;
    }

    public InfaktInvoiceResponse withEntities(final List<Invoice> entities) {
        this.entities = entities;
        return this;
    }

    public InfaktInvoiceResponse withMetaInfo(final org.singularitylab.infakt.client.impl.MetaInfo metaInfo) {
        this.metaInfo = metaInfo;
        return this;
    }


}
