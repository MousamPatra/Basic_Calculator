package com.example.calculatortest02.logic.math_operations;

public class Multiply implements OperationInterface{

    @Override
    public String Calculation(double v1, double v2) {

        double answer = v1 * v2;
        return "The multiplication of "
                + v1
                + " and "
                + v2
                + " is "
                + answer;
    }
}
