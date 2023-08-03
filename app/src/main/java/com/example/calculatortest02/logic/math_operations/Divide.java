package com.example.calculatortest02.logic.math_operations;

public class Divide implements OperationInterface{

    @Override
    public String Calculation(double v1, double v2) {
        if(v2 == 0 || v1 == 0){
            return "0 is not a correct value!!";
        }
        double answer = v1 / v2;
        double reminder = v1 % v2;
        return "The division of "
                + v2
                + " to "
                + v1
                + " is "
                + answer
                + " and reminder is "
                + reminder;
    }
}
