package org.singularitylab.infakt.client;

import org.singularitylab.infakt.client.model.Customer;

import java.util.List;

/**
 * @author Jakub Dzon
 */
public interface CustomerClient {
    List<Customer> find(String property, String value);

    Customer create(Customer customer);
}
