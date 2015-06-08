package org.singularitylab.infakt.client;

import org.singularitylab.infakt.client.model.Invoice;

import java.util.List;

/**
 * @author Jakub Dzon
 */
public interface InvoiceClient {
    List<Invoice> findAll();
}
