package org.singularitylab.infakt.client.impl.customer;

import org.singularitylab.infakt.client.impl.InfaktResponse;
import org.singularitylab.infakt.client.model.Customer;
import org.singularitylab.infakt.client.model.Invoice;

import java.util.List;

/**
 * @author Jakub Dzon
 */
class InfaktCustomerResponse extends InfaktResponse {

    private List<Customer> entities;

    public List<Customer> getEntities() {
        return entities;
    }

    public void setEntities(List<Customer> entities) {
        this.entities = entities;
    }

    public InfaktCustomerResponse withEntities(final List<Customer> entities) {
        this.entities = entities;
        return this;
    }

    public InfaktCustomerResponse withMetaInfo(final org.singularitylab.infakt.client.impl.MetaInfo metaInfo) {
        this.metaInfo = metaInfo;
        return this;
    }


}
