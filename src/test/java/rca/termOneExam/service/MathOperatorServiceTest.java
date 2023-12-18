package rca.termOneExam.service;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import rca.termOneExam.v1.exceptions.InvalidOperationException;
import rca.termOneExam.v1.serviceImpls.MathOperatorImpl;
import rca.termOneExam.v1.services.IMathOperator;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MathOperatorServiceTest {
    @Mock
    private IMathOperator mathOperator;

    @InjectMocks
    private MathOperatorImpl mathOperatorService;

    @Test
    public void should_create_math_operation_success_Addition() throws InvalidOperationException {
        double operator1 = 4;
        double operator2 = 9;
        String operation = "+";

        // Stubbing behavior for mathOperatorImpl.doMath()
        when(mathOperator.doMath(operator1, operator2, operation)).thenReturn(operator1 + operator2);

        double actualMathOperator = mathOperatorService.doMath(operator1, operator2, operation);

        assertThat(actualMathOperator).isEqualTo(operator1 + operator2);
    }

    @Test
    public void should_create_math_operation_success_Subtraction() throws InvalidOperationException {
        double operator1 = 9;
        double operator2 = 4;
        String operation = "-";

        // Stubbing behavior for mathOperatorImpl.doMath()
        when(mathOperator.doMath(operator1, operator2, operation)).thenReturn(operator1 - operator2);

        double actualMathOperator = mathOperatorService.doMath(operator1, operator2, operation);

        assertThat(actualMathOperator).isEqualTo(operator1 - operator2);
    }

    @Test
    public void should_create_math_operation_success_Multiplication() throws InvalidOperationException {
        double operator1 = 4;
        double operator2 = 9;
        String operation = "*";

        // Stubbing behavior for mathOperatorImpl.doMath()
        when(mathOperator.doMath(operator1, operator2, operation)).thenReturn(operator1 * operator2);

        double actualMathOperator = mathOperatorService.doMath(operator1, operator2, operation);

        assertThat(actualMathOperator).isEqualTo(operator1 * operator2);
    }

    @Test(expected = InvalidOperationException.class)
    public void should_throw_exception_when_division_by_zero() throws InvalidOperationException {
        double operator1 = 9;
        double operator2 = 0; // Division by zero
        String operation = "/";

        mathOperatorService.doMath(operator1, operator2, operation);
    }

    //Integration Testing
    @Test
    public void testDoMath_Integration_Addition() throws InvalidOperationException {
        when(mathOperator.doMath(anyDouble(), anyDouble(), anyString())).thenReturn(8.0);
        double result = mathOperatorService.doMath(5, 3, "+");
        assertEquals(8, result, 0.001);
    }
    @Test
    public void testDoMath_Integration_Multiplication() throws InvalidOperationException {
        when(mathOperator.doMath(anyDouble(), anyDouble(), anyString())).thenReturn(15.0);
        double result = mathOperatorService.doMath(5, 3, "*");
        assertEquals(15, result, 0.001);
    }

    @Test
    public void testDoMath_Integration_Subtraction() throws InvalidOperationException {
        when(mathOperator.doMath(anyDouble(), anyDouble(), anyString())).thenReturn(2.0);
        double result = mathOperatorService.doMath(5, 3, "-");

        assertEquals(2, result, 0.001);
    }

    @Test
    public void testDoMath_Integration_Division() throws InvalidOperationException {
        when(mathOperator.doMath(anyDouble(), anyDouble(), anyString())).thenReturn(2.5);
        double result = mathOperatorService.doMath(5, 2, "/");
        assertEquals(2.5, result, 0.001);
    }
    @Test
    public void testDoMath_Integration_DivisionByZero() throws InvalidOperationException {
        when(mathOperator.doMath(anyDouble(), anyDouble(), anyString()))
                .thenThrow(new InvalidOperationException("Cannot divide by 0"));
        assertThrows(InvalidOperationException.class, () -> mathOperatorService.doMath(10, 0, "/"));
    }

    //End-to-End Testing
    @Test
    public void testCalculatorService_EndToEnd() throws InvalidOperationException {

        MathOperatorImpl mathOperator = new MathOperatorImpl();


        double resultAddition = mathOperator.doMath(5, 3, "+");
        assertEquals(8, resultAddition, 0.001);


        double resultSubtraction = mathOperator.doMath(9, 4, "-");
        assertEquals(5, resultSubtraction, 0.001);


        double resultMultiplication = mathOperator.doMath(4, 3, "*");
        assertEquals(12, resultMultiplication, 0.001);


        double resultDivision = mathOperator.doMath(10, 2, "/");
        assertEquals(5, resultDivision, 0.001);
    }

}
