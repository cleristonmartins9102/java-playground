package CallablePromisePoc.services;

import CallablePromisePoc.contracts.HttpClient;
import CallablePromisePoc.models.ProductModel;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RemoteGetProducts {
    HttpClient<List<ProductModel>> httpClient;
    public RemoteGetProducts(HttpClient<List<ProductModel>> httpClient) {
        this.httpClient = httpClient;
    }
    public List<ProductModel> load() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<List<ProductModel>> future = executor.submit(() -> this.httpClient.request("GET", "http://getprod"));
        try {
            return future.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            executor.shutdown();
        }
    }
}
