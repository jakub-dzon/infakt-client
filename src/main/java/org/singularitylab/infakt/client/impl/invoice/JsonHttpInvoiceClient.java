package org.singularitylab.infakt.client.impl.invoice;

import org.singularitylab.infakt.client.InvoiceClient;
import org.singularitylab.infakt.client.model.Invoice;
import org.singularitylab.infakt.client.model.InvoiceLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
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
    public JsonHttpInvoiceClient(RestTemplate restTemplate,
            @Value("${infakt.api.url}") String baseUrl) {
        this.restTemplate = restTemplate;
        this.baseUrl = baseUrl;
    }

    @Override
    public List<Invoice> findAll() {
        ResponseEntity<InfaktInvoiceResponse> responseEntity = restTemplate.getForEntity(baseUrl + "/invoices.json",
                InfaktInvoiceResponse.class);
        return responseEntity.getBody().getEntities();
    }

    @Override
    public Invoice create(Invoice invoice) {
        ResponseEntity<Invoice> result = restTemplate.postForEntity(baseUrl + "/invoices.json", invoice, Invoice
                .class);
        return result.getBody();
    }

    @Override
    public byte[] print(Invoice invoice, InvoiceLanguage language) {
        String url = baseUrl + "/invoices/{id}/pdf.json?document_type=regular&locale={locale}";
        ResponseEntity<byte[]> responseEntity = restTemplate.getForEntity(url, byte[].class, invoice.getId(), language.getCode());
        HttpStatus statusCode = responseEntity.getStatusCode();
        if (statusCode == HttpStatus.OK) {
            return responseEntity.getBody();
        } else {
            throw new IllegalStateException("Got " + statusCode);
        }
    }
}
