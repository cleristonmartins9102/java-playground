package CallablePromisePoc;

import CallablePromisePoc.infra.HttpClientAdapter;
import CallablePromisePoc.services.RemoteGetProducts;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        RemoteGetProducts remoteGetProd = new RemoteGetProducts(new HttpClientAdapter());
        var products = remoteGetProd.load();
        System.out.println("Loaded " + products.size() + " products");
    }
}
