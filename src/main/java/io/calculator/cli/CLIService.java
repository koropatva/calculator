package io.calculator.cli;

import java.io.Console;

public class CLIService {

    private Console console;

    public CLIService() {
        console = System.console();
    }

    public void startProcess() {
        do {
            System.out.println(console.readLine());
        } while (true);
    }
}
