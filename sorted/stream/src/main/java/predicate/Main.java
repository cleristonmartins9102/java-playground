package predicate;

import java.util.ArrayList;

class Product {

    String brand;
    String variation;
    String sku;
    String category;

    public Product(
            String brand,
            String variation,
            String sku,
            String category
    ) {
        this.brand = brand;
        this.variation = variation;
        this.category = category;
        this.sku = sku;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public String toString() {
        return brand;
    }
}

public class Main {

    public static void main(String[] args) {

        final Product mobilePhone =
                new Product(
                        "iphone",
                        "G1",
                        "1002-1",
                        "MOBILE_PHONE"
                );

        final Product mobilePhone2 =
                new Product(
                        "samsung",
                        "G1",
                        "1002-1",
                        "MOBILE_PHONE"
                );

        final Product television =
                new Product(
                        "computer",
                        "G2",
                        "1003-1",
                        "APPLIANCE"
                );

        var products =
                new ArrayList<Product>();

        products.add(mobilePhone);
        products.add(mobilePhone2);
        products.add(television);

        var sortedProducts =
                products.stream()
                        .sorted(
                                (p1, p2) ->
                                        p1.getBrand()
                                                .compareTo(
                                                        p2.getBrand()
                                                )
                        )
                        .toList();

        sortedProducts.forEach(
                System.out::println
        );
    }
}