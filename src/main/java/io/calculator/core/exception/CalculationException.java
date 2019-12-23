package io.calculator.core.exception;

public class CalculationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CalculationException() {
        super("Not enough data to calculate the operation");
    }
}
