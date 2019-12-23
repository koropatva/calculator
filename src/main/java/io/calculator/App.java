package io.calculator;

import io.calculator.cli.CLIService;

public class App {

    public static void main(String... args) {
        new Thread(() -> new CLIService().startProcess()).start();
    }
}
