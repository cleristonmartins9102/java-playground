package predicate;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;


class Product {
    String name;
    String category;
    double price;
    int stock;

    Product(String name, String category, double price, int stock) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }
}

class Filter {
    String field;
    String operator;
    Object value;

    Filter(String field, String operator, Object value) {
        this.field = field;
        this.operator = operator;
        this.value = value;
    }
}

public class Main {
    static void main() {
        List<Product> products = List.of(
                new Product("Notebook", "ELECTRONICS", 3000, 10),
                new Product("Mouse", "ELECTRONICS", 50, 100),
                new Product("Keyboard", "ELECTRONICS", 150, 50),
                new Product("Chair", "FURNITURE", 500, 5)
        );

        List<Filter> filters = List.of(
                new Filter("category", "=", "ELECTRONICS"),
                new Filter("price", "<", 1000.0),
                new Filter("name", "contains", "o")
        );

        List<Product> result = applyFilters(products, filters, "AND");

        result.forEach(p ->
                System.out.println(p.name + " - " + p.price)
        );
    }

    static List<Product> applyFilters(
            List<Product> list,
            List<Filter> filters,
            String combination
    ) {

        List<Predicate<Product>> predicates = filters.stream()
                .map(Main::buildPredicate)
                .collect(Collectors.toList());

        Predicate<Product> combined = "OR".equalsIgnoreCase(combination)
                ? predicates.stream().reduce(p -> false, Predicate::or)
                : predicates.stream().reduce(p -> true, Predicate::and);

        return list.stream()
                .filter(combined)
                .collect(Collectors.toList());
    }

    static Predicate<Product> buildPredicate(Filter f) {

        switch (f.field) {

            case "category":
                return p -> compareString(p.category, f.operator, f.value);

            case "name":
                return p -> compareString(p.name, f.operator, f.value);

            case "price":
                return p -> compareDouble(p.price, f.operator, f.value);

            case "stock":
                return p -> compareInt(p.stock, f.operator, f.value);

            default:
                return p -> true;
        }
    }

    static boolean compareString(String field, String op, Object value) {
        String v = (String) value;

        switch (op) {
            case "=": return field.equals(v);
            case "contains": return field.contains(v);
            default: return false;
        }
    }

    static boolean compareDouble(double field, String op, Object value) {
        double v = (double) value;

        switch (op) {
            case ">": return field > v;
            case "<": return field < v;
            case "=": return field == v;
            default: return false;
        }
    }

    static boolean compareInt(int field, String op, Object value) {
        int v = (int) value;

        switch (op) {
            case ">": return field > v;
            case "<": return field < v;
            case "=": return field == v;
            default: return false;
        }
    }
}
