package io.calculator.core.operation;

import static io.calculator.core.operation.enums.OperationEnum.SUBTRACT;

import java.math.BigDecimal;

import io.calculator.core.operation.interfaces.Operation;

public class Subtract implements Operation {

    @Override
    public BigDecimal calculate(BigDecimal firstArg, BigDecimal secondArg) {
        return firstArg.subtract(secondArg);
    }

    @Override
    public String getRegExp() {
        return SUBTRACT.getRegExp();
    }
}
