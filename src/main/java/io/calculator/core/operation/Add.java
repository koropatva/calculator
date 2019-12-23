package io.calculator.core.operation;

import static io.calculator.core.operation.enums.OperationEnum.ADD;

import java.math.BigDecimal;

import io.calculator.core.operation.interfaces.Operation;

public class Add implements Operation {

    @Override
    public BigDecimal calculate(BigDecimal firstArg, BigDecimal secondArg) {
        return firstArg.add(secondArg);
    }

    @Override
    public String getRegExp() {
        return ADD.getRegExp();
    }
}
