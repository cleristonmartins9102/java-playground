package predicates;

import java.util.List;
import java.util.function.Predicate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        Predicate<String> predicateFilter = (value) -> value.startsWith("Co");
       List<String> list = List.of("Computer", "Mobile", "Meet", "Vegetable", "Corners");
       list.stream()
               .filter(predicateFilter)
               .forEach(System.out::println);
    }
}
