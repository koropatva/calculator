package io.calculator.core;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import io.calculator.core.exception.CalculationException;
import io.calculator.core.validation.exception.ValidationException;

public class CalculatorEngineTest {

    private CalculatorEngine calculatorEngine;

    @Before
    public void setup() {
        calculatorEngine = new CalculatorEngine();
    }

    @Test(expected = ValidationException.class)
    public void testValidationException() {
        calculatorEngine.calculate("wrong args");
    }

    @Test(expected = CalculationException.class)
    public void testCalculationException() {
        calculatorEngine.calculate("2 +");
    }

    @Test(expected = CalculationException.class)
    public void testDivideOnZeroException() {
        calculatorEngine.calculate("2 0 /");
    }

    @Test
    public void testOperationFunctionality() {
        assertThat(calculatorEngine.calculate("5")).isEqualTo("5");
        assertThat(calculatorEngine.calculate("8")).isEqualTo("8");
        assertThat(calculatorEngine.calculate("+")).isEqualTo("13");
        assertThat(calculatorEngine.calculate("C")).isEqualTo(CalculatorEngine.CLEAR_CALCULATION_MEMORY);

        assertThat(calculatorEngine.calculate("5 8 +")).isEqualTo("13");
        assertThat(calculatorEngine.calculate("13.0 -")).isEqualTo("0.0");
        assertThat(calculatorEngine.calculate("C")).isEqualTo(CalculatorEngine.CLEAR_CALCULATION_MEMORY);

        assertThat(calculatorEngine.calculate("-3")).isEqualTo("-3");
        assertThat(calculatorEngine.calculate("-2")).isEqualTo("-2");
        assertThat(calculatorEngine.calculate("*")).isEqualTo("6");
        assertThat(calculatorEngine.calculate("5")).isEqualTo("5");
        assertThat(calculatorEngine.calculate("+")).isEqualTo("11");
        assertThat(calculatorEngine.calculate("C")).isEqualTo(CalculatorEngine.CLEAR_CALCULATION_MEMORY);

        assertThat(calculatorEngine.calculate("5")).isEqualTo("5");
        assertThat(calculatorEngine.calculate("9")).isEqualTo("9");
        assertThat(calculatorEngine.calculate("1")).isEqualTo("1");
        assertThat(calculatorEngine.calculate("-")).isEqualTo("8");
        assertThat(calculatorEngine.calculate("/")).isEqualTo("0.625");
        assertThat(calculatorEngine.calculate("C")).isEqualTo(CalculatorEngine.CLEAR_CALCULATION_MEMORY);

        calculatorEngine.calculate("1 2 3");
        assertThat(calculatorEngine.calculate("P")).isEqualTo("3 2 1");
        assertThat(calculatorEngine.calculate("+")).isEqualTo("5");
        assertThat(calculatorEngine.calculate("-")).isEqualTo("-4");
        assertThat(calculatorEngine.calculate("-1 *")).isEqualTo("4");
        assertThat(calculatorEngine.calculate("2 /")).isEqualTo("2");
    }
}
