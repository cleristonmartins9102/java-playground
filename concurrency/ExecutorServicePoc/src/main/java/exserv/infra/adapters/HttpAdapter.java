package exserv.infra.adapters;

import exserv.features.contracts.HttpClient;
import exserv.features.contracts.HttpResponse;

public class HttpAdapter implements HttpClient {
    @Override
    public HttpResponse request(String method, String url) {
        // Simulate HTTP delay
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        HttpResponse response = new HttpResponse();
        response.status = 200;
        response.body = null;
        System.out.println("Request to " + url + " completed with status " + response.status);
        return response;
    }
}
