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
import org.singularitylab.infakt.client.model.InvoiceKind;
import org.singularitylab.infakt.client.model.InvoiceLanguage;
import org.singularitylab.infakt.client.model.PaymentMethod;
import org.singularitylab.infakt.client.model.SaleType;
import org.singularitylab.infakt.client.model.Service;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.util.Collections.singletonList;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * @author Jakub Dzon
 */
public class JsonHttpInvoiceClientIntegrationTest {

    private InvoiceClient invoiceClient;

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @Before
    public void setUp() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(
                singletonList(new InfaktAuthInterceptor("XXX")));
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2HttpMessageConverter jsonMessageConverter = new MappingJackson2HttpMessageConverter();

        ObjectMapper objectMapper = new ObjectMapper().configure(JsonParser.Feature.ALLOW_COMMENTS, true)
                .configure(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS, true)
                .configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true)
                .configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true)
                .configure(JsonGenerator.Feature.QUOTE_FIELD_NAMES, true)
                .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
                .configure(SerializationFeature.INDENT_OUTPUT, true)
                .configure(SerializationFeature.WRAP_ROOT_VALUE, true)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true)
                .setSerializationInclusion(JsonInclude.Include.NON_NULL);

        jsonMessageConverter.setObjectMapper(objectMapper);
        messageConverters.add(jsonMessageConverter);
        messageConverters.add(new ByteArrayHttpMessageConverter());
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
        Invoice invoice = Invoice.builder()
                .withClientId(3791589)
                .withClientCompanyName("Jakub Dzon Singularity Lab")
                .withSaleDate(DATE_FORMAT.format(new Date()))
                .withPaymentDate(DATE_FORMAT.format(new Date()))
                .withKind(InvoiceKind.VAT)
                .withPaymentMethod(PaymentMethod.TRANSFER)
                .withSaleType(SaleType.SERVICE)
                .withBankName("Idea Bank")
                .withBankAccount("PL87195000012006045286540002")
                .withSellerSignature("Jakub Dżon")
                .withServices(
                        singletonList(
                                Service.builder()
                                        .withName("Foo")
                                        .withUnitNetPrice(100)
                                        .withQuantity(1)
                                        .withTaxSymbol("23")
                                        .withUnit("szt.")
                                        .build()
                        )
                ).build();

        // When
        Invoice created = invoiceClient.create(invoice);

        // Then
        assertThat(created, notNullValue());
    }

    @Test
    public void shouldPrint() throws IOException {
        //Given

        // When
        byte[] invoice = invoiceClient.print(Invoice.builder().withId(11038792).build(), InvoiceLanguage.BOTH);

        // Then
        FileOutputStream fileOutputStream = new FileOutputStream("/tmp/x.pdf");
        fileOutputStream.write(invoice);
        fileOutputStream.close();
    }
}