package io.calculator.core.validation.rules;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import io.calculator.core.operation.enums.OperationEnum;
import io.calculator.core.validation.Rule;

public class OperationRule implements Rule {

    private List<String> operators;

    public OperationRule() {
        operators = Arrays.stream(OperationEnum.values()).map(OperationEnum::getRegExp).collect(Collectors.toList());
    }

    @Override
    public boolean invalid(String expression) {
        return operators.stream().noneMatch(expression::matches);
    }
}
