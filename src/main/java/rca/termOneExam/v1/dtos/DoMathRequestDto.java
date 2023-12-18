package rca.termOneExam.v1.dtos;

import lombok.Data;

@Data

public class DoMathRequestDto {
    private double num1;
    private double num2;
    private String operation;

    public DoMathRequestDto(double num1, double num2, String operation) {
        this.num1 = num1;
        this.num2 = num2;
        this.operation = operation;
    }


    public double getNum1() {
        return num1;
    }

    public void setNum1(double operand1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNUm2(double operand2) {
        this.num2 = num2;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
