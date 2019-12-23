package io.calculator.cli;

import java.util.Scanner;

import io.calculator.core.CalculatorEngine;
import io.calculator.core.exception.CalculationException;
import io.calculator.core.validation.exception.ValidationException;

public class CLIService {

    private static final String EXIT_CHARACTER = "q";
    private Scanner scanner;
    private CalculatorEngine calculatorEngine;

    public CLIService() {
        this.scanner = new Scanner(System.in);
        this.calculatorEngine = new CalculatorEngine();
    }

    public void startProcess() {
        System.out.println("Calculator is UP. You can start to make your calculations.");
        boolean infiniteLoop = true;
        do {
            try {
                String arg = scanner.nextLine();
                if (EXIT_CHARACTER.equals(arg)) {
                    infiniteLoop = false;
                } else {
                    System.out.println("> " + arg);
                    System.out.println(calculatorEngine.calculate(arg));
                }
            } catch (CalculationException | ValidationException e) {
                System.out.println(e.getMessage());
            }
        } while (infiniteLoop);
        System.out.println("Calculator is DOWN.");
    }
}
