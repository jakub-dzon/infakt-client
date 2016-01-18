package org.singularitylab.infakt.client.model;

/**
 * @author Jakub Dzon
 */
public enum InvoiceLanguage {
    POLISH("pl"),
    ENGLISH("en"),
    BOTH("pe");

    private final String code;

    InvoiceLanguage(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
