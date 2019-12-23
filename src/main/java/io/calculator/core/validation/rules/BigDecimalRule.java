package io.calculator.core.validation.rules;

import java.math.BigDecimal;

import io.calculator.core.validation.Rule;

public class BigDecimalRule implements Rule {

    @Override
    public boolean invalid(String expression) {
        try {
            new BigDecimal(expression);
        } catch (NumberFormatException e) {
            return true;
        }
        return false;
    }
}
