package exserv.features.contracts;

public interface HttpClient {
    HttpResponse request(String method, String url);
}
