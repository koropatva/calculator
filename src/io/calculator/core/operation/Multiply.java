package io.calculator.core.operation;

import static io.calculator.core.operation.enums.OperationEnum.MULTIPLY;

import java.math.BigDecimal;

import io.calculator.core.operation.interfaces.Operation;

public class Multiply implements Operation {

    @Override
    public BigDecimal calculate(BigDecimal firstArg, BigDecimal secondArg) {
        return firstArg.multiply(secondArg);
    }
    
    @Override
    public String getRegExp() {
        return MULTIPLY.getRegExp();
    }
}
