package exserv;

import exserv.domain.GetBasket;
import exserv.features.RemoteGetBasket;
import exserv.infra.adapters.HttpAdapter;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("ExecutorService POC\n");
        final GetBasket remoteGetBaskets = new RemoteGetBasket(new HttpAdapter());
        var result = remoteGetBaskets.get(List.of("10s", "30s", "40s", "50s"));
        System.out.println("\nResult");
        System.out.println(result);
    }
}
