package rca.termOneExam.v1.serviceImpls;

import org.springframework.stereotype.Service;
import rca.termOneExam.v1.exceptions.InvalidOperationException;
import rca.termOneExam.v1.services.IMathOperator;

@Service
public class MathOperatorImpl implements IMathOperator {

    @Override
    public double doMath(double num1, double num2, String operation) throws InvalidOperationException {
        if ("/".equals(operation) && num2 == (double) 0) {
            throw new InvalidOperationException("Cannot divide by 0");
        }

        switch (operation) {

                case "*":
                    return num1 * num2;
                case "/":
                    return num1 / num2;
                case "+":
                    return num1 + num2;
                case "-":
                    return num1 - num2;
                default:
                    throw new RuntimeException("Unknown operation");
            }
        }
    }


