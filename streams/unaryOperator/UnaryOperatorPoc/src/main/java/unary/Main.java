package unary;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


import java.util.function.Function;
import java.util.function.UnaryOperator;


public class Main {
    static void main() {
        UnaryOperator<Double> calcSalerBonus = orderValue -> (orderValue * 10) / 100;
        UnaryOperator<Double> calcSalerBonusVat = bonus -> (bonus * 4) / 100;
        Function<Double, Double> result = calcSalerBonus.andThen(calcSalerBonusVat);

        System.out.println("Saler Bonus: " + calcSalerBonus.apply(1000.00));
        System.out.println("Saler VAT: " + result.apply(1000.00));

        Function<Double, Double> result2 = calcSalerBonus.compose(calcSalerBonusVat);
        System.out.println(result2.apply(10.00));
        System.out.println("VAT: " + result.apply(1000.00));

        UnaryOperator<String> value = v -> v;
        System.out.println(value.identity(
                GIT_COMMITTER_DATE="2026-06-04 10:33:11 -0300" git commit --amend --no-edit --date="2026-06-05 23:00:00 -0300"));
    }
}
