package org.singularitylab.infakt.client.impl.customer;

import org.singularitylab.infakt.client.CustomerClient;
import org.singularitylab.infakt.client.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Jakub Dzon
 */
@Component
class JsonHttpCustomerClient implements CustomerClient {

    private final RestTemplate restTemplate;

    private final String baseUrl;

    @Autowired
    public JsonHttpCustomerClient(RestTemplate restTemplate,
            @Value("${infakt.api.url}") String baseUrl) {
        this.restTemplate = restTemplate;
        this.baseUrl = baseUrl;
    }

    @Override
    public List<Customer> find(String property, String value) {
        ResponseEntity<InfaktCustomerResponse> responseEntity = restTemplate
                .getForEntity(baseUrl + "/clients.json?q[{property}_eq]={value}", InfaktCustomerResponse.class,
                        property, value);
        return responseEntity.getBody().getEntities();
    }

    @Override
    public Customer create(Customer customer) {
        ResponseEntity<Customer> result =
                restTemplate.postForEntity(baseUrl + "/customers.json", customer, Customer.class);
        return result.getBody();
    }
}
