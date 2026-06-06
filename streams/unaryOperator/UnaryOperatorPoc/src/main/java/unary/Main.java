package unary;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


import java.util.function.UnaryOperator;


public class Main {
    static void main() {
        UnaryOperator<Double> calcSalerBonus = orderValue -> (orderValue * 10) / 100;
        System.out.println("Saler Bonud: " + calcSalerBonus.apply(1000.00));
    }
}
