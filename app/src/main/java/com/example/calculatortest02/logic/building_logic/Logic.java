package com.example.calculatortest02.logic.building_logic;

import com.example.calculatortest02.logic.math_operations.Add;
import com.example.calculatortest02.logic.math_operations.Divide;
import com.example.calculatortest02.logic.math_operations.Multiply;
import com.example.calculatortest02.logic.math_operations.OperationInterface;
import com.example.calculatortest02.logic.math_operations.Subtract;
import com.example.calculatortest02.ui.OutputInterface;

public class Logic implements LogicInterface{

    final private OutputInterface mOut;
    public Logic(OutputInterface mOut) {
        this.mOut = mOut;
    }

    @Override
    public void process() {

        double value1 = mOut.getValue1();
        double value2 = mOut.getValue2();
        MathOperations selectedOperation = mOut.getSelectedOperation();

        OperationInterface mOperation;
        switch (selectedOperation){
            case Addition:
                mOperation = new Add();
                mOut.printOutput(mOperation.Calculation(value1,value2));
                break;
            case Subtraction:
                mOperation = new Subtract();
                mOut.printOutput(mOperation.Calculation(value1,value2));
                break;
            case Multiplication:
                mOperation = new Multiply();
                mOut.printOutput(mOperation.Calculation(value1,value2));
                break;
            case Division:
                mOperation = new Divide();
                mOut.printOutput(mOperation.Calculation(value1,value2));
                break;
            default:
                mOut.printOutput("Invalid Operation!");
        }
    }
}
