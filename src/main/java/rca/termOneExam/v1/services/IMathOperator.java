package rca.termOneExam.v1.services;

import rca.termOneExam.v1.exceptions.InvalidOperationException;

public interface IMathOperator {

    double doMath(double operand1, double operand2, String operation) throws InvalidOperationException;
}
