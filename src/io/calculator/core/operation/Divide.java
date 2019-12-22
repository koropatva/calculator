package io.calculator.core.operation;

import static io.calculator.core.operation.enums.OperationEnum.DIVIDE;

import java.math.BigDecimal;

import io.calculator.core.operation.interfaces.Operation;

public class Divide implements Operation {

    @Override
    public BigDecimal calculate(BigDecimal firstArg, BigDecimal secondArg) {
        return firstArg.divide(secondArg);
    }
    
    @Override
    public String getRegExp() {
        return DIVIDE.getRegExp();
    }
}
