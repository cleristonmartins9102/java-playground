package predicates;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class Product {
    String id;
    String description;
    String category;

    void setId(String id) {
        this.id = id;
    }

    String getId() {
        return this.id;
    }

    void setDescription(String description) {
        this.description = description;
    }

    void setCategory(String category) {
        this.category = category;
    }
}

class Basket {
    List<Product> products = new ArrayList<Product>();
    Predicate<Product> productIncluded = (product) -> this.products.stream().anyMatch(p -> p.getId().equals(product.getId()));
    void add(Product product) {
        System.out.println("CHECKING IF EXISTS PRODUCT INTO THE BASKET " + product.getId() + " " + productIncluded.test(product));
        if (!productIncluded.test(product)) {
            this.products.add(product);
        }
    }
}

public class Main {
    static void main() {
        // Testing Predicate as a lambda
        Predicate<String> predicateFilter = (value) -> value.startsWith("Co");
       List<String> list = List.of("Computer", "Mobile", "Meet", "Vegetable", "Corners");
       list.stream()
               .filter(predicateFilter)
               .forEach(System.out::println);

       var basket = new Basket();
       var mobile = new Product();
       mobile.id = "01";
       mobile.description = "Iphone";
       mobile.category = "communication";

       // Testing Predicate as a function in an object attribute
       basket.add(mobile);
       basket.add(mobile);
    }
}
