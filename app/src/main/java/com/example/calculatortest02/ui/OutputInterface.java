package com.example.calculatortest02.ui;

import com.example.calculatortest02.logic.building_logic.MathOperations;

public interface OutputInterface {

    double getValue1();
    double getValue2();
    MathOperations getSelectedOperation();
    void resetOutput();
    void printOutput(String output);
}
