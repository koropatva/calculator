package io.calculator;

import io.calculator.core.CalculatorEngine;

public class App {

    private static CalculatorEngine calculatorEngine = new CalculatorEngine();

    public static void main(String... args) {
        // System.out.println(calculatorEngine.calculate("5"));
        // System.out.println(calculatorEngine.calculate("8"));
        // System.out.println(calculatorEngine.calculate("+"));

        // System.out.println(calculatorEngine.calculate("5 8 +"));
        // System.out.println(calculatorEngine.calculate("13 -"));

        // System.out.println(calculatorEngine.calculate("-3"));
        // System.out.println(calculatorEngine.calculate("-2"));
        // System.out.println(calculatorEngine.calculate("*"));
        // System.out.println(calculatorEngine.calculate("5"));
        // System.out.println(calculatorEngine.calculate("+"));

        System.out.println(calculatorEngine.calculate("5"));
        System.out.println(calculatorEngine.calculate("9"));
        System.out.println(calculatorEngine.calculate("1"));
        System.out.println(calculatorEngine.calculate("-"));
        System.out.println(calculatorEngine.calculate("/"));
    }
}
