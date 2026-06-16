package exserv.features;

import exserv.domain.GetBasket;
import exserv.domain.models.BasketModel;
import exserv.features.contracts.HttpClient;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RemoteGetBasket implements GetBasket {
    HttpClient httpClient;
    public RemoteGetBasket(HttpClient httpClient) {
        this.httpClient = httpClient;
    }
    @Override
    public BasketModel get(List<String> userIds) {
        try {
            ExecutorService executor = Executors.newFixedThreadPool(4);
            System.out.println("Starting concurrent requests for " + userIds.size() + " users...");
            for (String id : userIds) {
                executor.submit(() -> {
                    System.out.println("Processing user: " + id);
                    return this.httpClient.request("POST", "http://fakeurl/" + id);
                });
            }
            executor.shutdown();
            System.out.println("All requests submitted!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        BasketModel result = new BasketModel();
        result.id = "basket-123";
        result.items = List.of();
        return result;
    }
}
