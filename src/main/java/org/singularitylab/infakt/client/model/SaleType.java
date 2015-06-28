package org.singularitylab.infakt.client.model;

/**
 * @author Jakub Dzon
 */
public enum SaleType {
    SERVICE, MERCHANDISE;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
