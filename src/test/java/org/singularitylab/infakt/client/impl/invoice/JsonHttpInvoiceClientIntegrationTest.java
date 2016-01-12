package org.singularitylab.infakt.client.impl.invoice;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Before;
import org.junit.Test;
import org.singularitylab.infakt.client.InvoiceClient;
import org.singularitylab.infakt.client.impl.InfaktAuthInterceptor;
import org.singularitylab.infakt.client.model.Invoice;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * @author Jakub Dzon
 */
public class JsonHttpInvoiceClientIntegrationTest {

    private InvoiceClient invoiceClient;

    @Before
    public void setUp() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(
                Collections.singletonList(new InfaktAuthInterceptor("XXX")));
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2HttpMessageConverter jsonMessageConverter = new MappingJackson2HttpMessageConverter();

        ObjectMapper objectMapper = new ObjectMapper().configure(JsonParser.Feature.ALLOW_COMMENTS, true)
                .configure(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS, true)
                .configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true)
                .configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true)
                .configure(JsonGenerator.Feature.QUOTE_FIELD_NAMES, true)
                .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
                .configure(SerializationFeature.INDENT_OUTPUT, true)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true)
                .setSerializationInclusion(JsonInclude.Include.NON_NULL);

        jsonMessageConverter.setObjectMapper(objectMapper);
        messageConverters.add(jsonMessageConverter);
        restTemplate.setMessageConverters(messageConverters);
        invoiceClient = new JsonHttpInvoiceClient(restTemplate, "https://api.infakt.pl/v3");
    }

    @Test
    public void shouldFindInvoice() {
        // When
        List<Invoice> results = invoiceClient.findAll();

        System.out.println(results);

        // Then
        assertThat(results, notNullValue());
    }

    @Test
    public void shouldCreateInvoice() {
        //Given
        Invoice invoice = new Invoice();
        invoice.setClientId(3791589);

        // When
        Invoice created = invoiceClient.create(invoice);


        System.out.println(created);

        // Then
        assertThat(created, notNullValue());
    }
}