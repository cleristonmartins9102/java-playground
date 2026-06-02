package consumer;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        List<Double> salaryItems = Arrays.asList(-10.0, 20.0, 30.0);
        BinaryOperator<Double> calcSalary = (a, b) -> {

            return b < 0.0 ? 0.0 + b : a + b;
        };
        Double salary = salaryItems.stream().reduce(0.0, calcSalary);
        System.out.println(salary);
    }
}
