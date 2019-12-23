package io.calculator.core.validation;

import java.util.ArrayList;
import java.util.List;

import io.calculator.core.validation.exception.ValidationException;
import io.calculator.core.validation.rules.BigDecimalRule;
import io.calculator.core.validation.rules.OperationRule;

public class ValidationService {

    private List<Rule> connectionRules;

    public ValidationService() {
        connectionRules = new ArrayList<>();
        connectionRules.add(new BigDecimalRule());
        connectionRules.add(new OperationRule());
    }

    public void validate(String expression) {
        if (connectionRules.stream().allMatch(rule -> rule.invalid(expression))) {
            throw new ValidationException(expression);
        }

    }
}
