package rca.termOneExam.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import rca.termOneExam.v1.exceptions.InvalidOperationException;
import rca.termOneExam.v1.serviceImpls.MathOperatorImpl;
import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MathOperatorServiceTest {

    @InjectMocks
    private MathOperatorImpl mathOperatorService;

    @Test
    public void should_create_math_operation_addition_success() throws InvalidOperationException {
        double operator1 = 4;
        double operator2 = 9;
        String operation = "+";

        double mathOperation = mathOperatorService.doMath(operator1, operator2, operation);
        when(mathOperatorService.doMath(operator1, operator2, operation)).thenReturn(mathOperation);

        double actualMathOperator = mathOperatorService.doMath(operator1, operator2, operation);

        assertThat(mathOperation).isEqualTo(actualMathOperator);
    }

    @Test
    public void should_create_math_operation_subtraction_success() throws InvalidOperationException {
        double operator1 = 10;
        double operator2 = 5;
        String operation = "-";

        double mathOperation = mathOperatorService.doMath(operator1, operator2, operation);
        when(mathOperatorService.doMath(operator1, operator2, operation)).thenReturn(mathOperation);

        double actualMathOperator = mathOperatorService.doMath(operator1, operator2, operation);

        assertThat(mathOperation).isEqualTo(actualMathOperator);
    }

    @Test
    public void should_create_math_operation_multiplication_success() throws InvalidOperationException {
        double operator1 = 6;
        double operator2 = 7;
        String operation = "*";

        double mathOperation = mathOperatorService.doMath(operator1, operator2, operation);
        when(mathOperatorService.doMath(operator1, operator2, operation)).thenReturn(mathOperation);

        double actualMathOperator = mathOperatorService.doMath(operator1, operator2, operation);

        assertThat(mathOperation).isEqualTo(actualMathOperator);
    }

    @Test
    public void should_create_math_operation_division_success() throws InvalidOperationException {
        double operator1 = 20;
        double operator2 = 4;
        String operation = "/";

        double mathOperation = mathOperatorService.doMath(operator1, operator2, operation);
        when(mathOperatorService.doMath(operator1, operator2, operation)).thenReturn(mathOperation);

        double actualMathOperator = mathOperatorService.doMath(operator1, operator2, operation);

        assertThat(mathOperation).isEqualTo(actualMathOperator);
    }
}
