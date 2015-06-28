package org.singularitylab.infakt.client.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author Jakub Dzon
 */
@Component
public class InfaktAuthInterceptor implements ClientHttpRequestInterceptor {

    private final String infaktApiKey;

    @Autowired
    public InfaktAuthInterceptor(@Value("${infakt.api.key}") String infaktApiKey) {
        this.infaktApiKey = infaktApiKey;
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        HttpHeaders headers = request.getHeaders();
        headers.add("X-inFakt-ApiKey", infaktApiKey);
        return execution.execute(request, body);
    }
}
