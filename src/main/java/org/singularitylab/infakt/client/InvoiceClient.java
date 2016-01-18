package org.singularitylab.infakt.client;

import org.singularitylab.infakt.client.model.Invoice;
import org.singularitylab.infakt.client.model.InvoiceLanguage;

import java.util.List;

/**
 * @author Jakub Dzon
 */
public interface InvoiceClient {

    List<Invoice> findAll();

    Invoice create(Invoice invoice);

    byte[] print(Invoice invoice, InvoiceLanguage language);
}
