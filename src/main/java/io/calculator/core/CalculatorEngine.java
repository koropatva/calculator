package io.calculator.core;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import io.calculator.core.exception.CalculationException;
import io.calculator.core.operation.Add;
import io.calculator.core.operation.Divide;
import io.calculator.core.operation.Multiply;
import io.calculator.core.operation.Subtract;
import io.calculator.core.operation.interfaces.Operation;
import io.calculator.core.validation.Rule;
import io.calculator.core.validation.ValidationService;
import io.calculator.core.validation.rules.BigDecimalRule;

public class CalculatorEngine {

    private static final String CLEAR_STACK_OPERATION = "C";
    private static final String EXPRESSION_SPLITTER = " ";

    private List<Operation> operations;
    private Deque<BigDecimal> data;

    private Rule bigDecimalRule;
    private ValidationService validationService;

    public CalculatorEngine() {
        this.data = new LinkedList<>();

        this.operations = new ArrayList<>();
        this.operations.add(new Add());
        this.operations.add(new Divide());
        this.operations.add(new Multiply());
        this.operations.add(new Subtract());

        this.validationService = new ValidationService();
        this.bigDecimalRule = new BigDecimalRule();
    }

    public String calculate(String expression) {
        String[] args = split(expression);

        if (args.length == 1 && CLEAR_STACK_OPERATION.equals(args[0])) {
            data.clear();
            return "Clear calculation memory.";
        }

        validateArgs(args);

        makeOperationOnArgs(args);

        return fetchResult().toString();
    }

    private void makeOperationOnArgs(String[] args) {
        Arrays.stream(args).forEach(arg -> {
            if (bigDecimalRule.invalid(arg)) {
                operations.stream().filter(o -> arg.matches(o.getRegExp())).findFirst().ifPresent(o -> {
                    if (data.size() < 2) {
                        throw new CalculationException();
                    }

                    BigDecimal secondArg = data.pop();
                    BigDecimal firstArg = data.pop();

                    data.push(o.calculate(firstArg, secondArg));
                });
            } else {
                data.push(new BigDecimal(arg));
            }
        });
    }

    private BigDecimal fetchResult() {
        BigDecimal result = data.pop();
        data.push(result);
        return result;
    }

    private void validateArgs(String[] args) {
        Arrays.stream(args).forEach(validationService::validate);
    }

    private String[] split(String expression) {
        return expression.trim().split(EXPRESSION_SPLITTER);
    }

}
