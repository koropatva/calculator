package io.calculator.cli;

import java.util.Scanner;

import io.calculator.core.CalculatorEngine;

public class CLIService {

    private Scanner scanner;
    private CalculatorEngine calculatorEngine;

    public CLIService() {
        this.scanner = new Scanner(System.in);
        this.calculatorEngine = new CalculatorEngine();
    }

    public void startProcess() {
        do {
            String arg = scanner.nextLine();
            System.out.println("> " + arg);
            System.out.println(calculatorEngine.calculate(arg));
        } while (true);
    }
}
