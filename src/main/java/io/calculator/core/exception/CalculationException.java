package io.calculator.core.exception;

public class CalculationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CalculationException(String e) {
        super(e);
    }
}
