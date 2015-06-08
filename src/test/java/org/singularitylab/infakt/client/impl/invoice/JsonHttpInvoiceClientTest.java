package org.singularitylab.infakt.client.impl.invoice;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.singularitylab.infakt.client.InvoiceClient;
import org.singularitylab.infakt.client.impl.MetaInfo;
import org.singularitylab.infakt.client.model.Invoice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

/**
 * @author Jakub Dzon
 */
@RunWith(MockitoJUnitRunner.class)
public class JsonHttpInvoiceClientTest {

    private InvoiceClient invoiceClient;

    @Mock
    private RestTemplate restTemplate;

    @Before
    public void setUp() throws Exception {
        this.invoiceClient = new JsonHttpInvoiceClient(restTemplate);
    }

    @Test
    public void shouldRetrieveAllInvoicesWithOnePage() {
        // Given
        int count = 9;
        int totalCount = 9;

        List<Invoice> entities = generateInvoices(count).collect(toList());
        MetaInfo metaInfo = new MetaInfo().withCount(count).withTotalCount(totalCount);
        InfaktInvoiceResponse invoiceResponse = buildInfaktResponse(entities, metaInfo);
        ResponseEntity<InfaktInvoiceResponse> responseEntity = new ResponseEntity<>(invoiceResponse, HttpStatus.OK);

        when(restTemplate.getForEntity("/invoices.json", InfaktInvoiceResponse.class)).thenReturn(responseEntity);

        // When
        List<Invoice> invoices = invoiceClient.findAll();

        // Then
        assertThat(invoices, notNullValue());
        assertThat(invoices.size(), is(totalCount));
    }

    @Test
    @Ignore("Not implemented yet")
    public void shouldRetrieveAllInvoicesWithMorePages() {
        // Given
        int count = 10;
        int totalCount = 30;

        List<Invoice> entities = generateInvoices(count).collect(toList());
        MetaInfo metaInfo = new MetaInfo()
                .withCount(count)
                .withTotalCount(totalCount);

        InfaktInvoiceResponse invoiceResponse = buildInfaktResponse(entities, metaInfo);
        ResponseEntity<InfaktInvoiceResponse> responseEntity = new ResponseEntity<>(invoiceResponse, HttpStatus.OK);

        when(restTemplate.getForEntity("/invoices.json", InfaktInvoiceResponse.class)).thenReturn(responseEntity);

        // When
        List<Invoice> invoices = invoiceClient.findAll();

        // Then
        assertThat(invoices, notNullValue());
        assertThat(invoices.size(), is(totalCount));
    }

    private InfaktInvoiceResponse buildInfaktResponse(List<Invoice> entities, MetaInfo metaInfo) {
        return new InfaktInvoiceResponse()
                .withEntities(entities)
                .withMetaInfo(metaInfo);
    }

    private Stream<Invoice> generateInvoices(int invoiceCount) {
        return IntStream.range(0, invoiceCount).mapToObj(n -> new Invoice());
    }

}