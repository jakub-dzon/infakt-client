package org.singularitylab.infakt.client.impl.invoice;

import org.singularitylab.infakt.client.InvoiceClient;
import org.singularitylab.infakt.client.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Jakub Dzon
 */
@Component
class JsonHttpInvoiceClient implements InvoiceClient {
    private final RestTemplate restTemplate;

    @Autowired
    public JsonHttpInvoiceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Invoice> findAll() {
        ResponseEntity<InfaktInvoiceResponse> responseEntity = restTemplate.getForEntity("/invoices.json", InfaktInvoiceResponse.class);
        return responseEntity.getBody().getEntities();
    }
}
