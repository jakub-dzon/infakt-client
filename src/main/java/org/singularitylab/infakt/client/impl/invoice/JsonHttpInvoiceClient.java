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

    private final String baseUrl;

    @Autowired
    public JsonHttpInvoiceClient(RestTemplate restTemplate, String baseUrl) {
        this.restTemplate = restTemplate;
        this.baseUrl = baseUrl;
    }

    @Override
    public List<Invoice> findAll() {
        ResponseEntity<InfaktInvoiceResponse> responseEntity = restTemplate.getForEntity(baseUrl + "/invoices.json", InfaktInvoiceResponse.class);
        return responseEntity.getBody().getEntities();
    }

    @Override
    public Invoice create(Invoice invoice) {
        ResponseEntity<Invoice> result = restTemplate.postForEntity(baseUrl + "/invoices.json", invoice, Invoice.class);
        return result.getBody();
    }
}
