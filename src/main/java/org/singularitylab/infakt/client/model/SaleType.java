package org.singularitylab.infakt.client.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author Jakub Dzon
 */
public enum SaleType {
    SERVICE,
    MERCHANDISE;

    @JsonValue
    @Override
    public String toString() {
        return name().toLowerCase();
    }

    @JsonCreator
    public static SaleType forValue(String value) {
        if (value == null || value.isEmpty()) {
            return SERVICE;
        }
        return SaleType.valueOf(value.toUpperCase());
    }
}
