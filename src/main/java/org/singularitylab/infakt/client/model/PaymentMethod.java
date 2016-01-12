package org.singularitylab.infakt.client.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author Jakub Dzon
 */
public enum PaymentMethod {
    TRANSFER,
    CASH,
    CARD,
    BARTER,
    CHECK,
    BILL_OF_SALE,
    DELIVERY,
    COMPENSATION,
    ACCREDITED,
    PAYPAL,
    PAYU,
    OTHER;

    @JsonValue
    @Override
    public String toString() {
        return name().toLowerCase();
    }

    @JsonCreator
    public static PaymentMethod forValue(String value) {
        return PaymentMethod.valueOf(value.toUpperCase());
    }

}