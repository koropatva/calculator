package io.calculator.core.operation.interfaces;

import java.math.BigDecimal;

public interface Operation {

    BigDecimal calculate(BigDecimal firstArg, BigDecimal secondArg);
    
    String getRegExp();
}
