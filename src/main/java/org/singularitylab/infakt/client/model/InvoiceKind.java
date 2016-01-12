package org.singularitylab.infakt.client.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author Jakub Dzon
 */
public enum InvoiceKind {
    FINAL,
    PROFORMA,
    VAT;

    @JsonValue
    @Override
    public String toString() {
        return name().toLowerCase();
    }

    @JsonCreator
    public static InvoiceKind forValue(String value) {
        return InvoiceKind.valueOf(value.toUpperCase());
    }

}
