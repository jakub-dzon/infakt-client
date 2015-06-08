package org.singularitylab.infakt.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Jakub Dzon
 */
public class Invoice {
    private int id;

    private String number;

    private Currency currency;

    @JsonProperty("paid_price")
    private int paidPrice;

    private String notes;


}
