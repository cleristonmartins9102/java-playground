package consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

class TaxCalculator {
    Consumer<List<Double>> taxCalc;
    public TaxCalculator(Consumer<List<Double>> taxCalc) {
        this.taxCalc = taxCalc;
    }

    public void calc(List<Double> wages) {
        this.taxCalc.accept(wages);
    }
}

public class Main {
    static void main() {
        List<Double> wagesAfterTax = new ArrayList<Double>();
        wagesAfterTax.add(1000.00);
        wagesAfterTax.add(3000.00);
        wagesAfterTax.add(30000.21);

        TaxCalculator taxCalcENG = new TaxCalculator(wages -> wages.forEach( w -> System.out.println("After Tax Deduction England: " + (w - (w * 25) / 100))));
        TaxCalculator taxCalcWAL = new TaxCalculator(wages -> wages.forEach( w -> System.out.println("After Tax Deduction Wales: " + (w - (w * 15) / 100))));
        TaxCalculator taxCalcSCO = new TaxCalculator(wages -> wages.forEach( w -> System.out.println("After Tax Deduction Scotland: " + (w - (w * 10) / 100))));

        wagesAfterTax.forEach(w -> System.out.println("Before Tax Deduction: " + w));

        taxCalcENG.calc(wagesAfterTax);
        taxCalcWAL.calc(wagesAfterTax);
        taxCalcSCO.calc(wagesAfterTax);
    }
}
