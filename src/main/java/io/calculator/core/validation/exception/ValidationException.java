package io.calculator.core.validation.exception;

public class ValidationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ValidationException(String expression) {
        super(String.format("Please enter valid expression, as '%s' can't be process", expression));
    }
}
