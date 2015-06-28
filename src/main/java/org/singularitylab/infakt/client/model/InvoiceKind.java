package org.singularitylab.infakt.client.model;

/**
 * @author Jakub Dzon
 */
public enum InvoiceKind {
    PROFORMA, VAT;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
