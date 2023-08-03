package com.example.calculatortest02.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calculatortest02.R;
import com.example.calculatortest02.logic.building_logic.Logic;
import com.example.calculatortest02.logic.building_logic.LogicInterface;
import com.example.calculatortest02.logic.building_logic.MathOperations;

public class MainActivity extends AppCompatActivity implements OutputInterface{

    private EditText value1, value2;
    private TextView answerTextView;
    private Button proceedBtn;
    private Spinner mMathSpinner;

    LogicInterface mLogic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mLogic = new Logic(this);
        initializeUI();
    }

    private void initializeUI() {
        setContentView(R.layout.activity_main);

        value1 = findViewById(R.id.inputValue1);
        value2 = findViewById(R.id.inputValue2);
        answerTextView = findViewById(R.id.answerTextView);
        proceedBtn = findViewById(R.id.proceedButton);
        mMathSpinner = findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> mAdapter = ArrayAdapter.createFromResource(this,
                R.array.math_options,
                R.layout.spinner_item);
        mAdapter.setDropDownViewResource(R.layout.spinner_item);

        mMathSpinner.setAdapter(mAdapter);

        mMathSpinner.setSelection(0);

        proceedBtn.setOnClickListener(v -> ButtonClicked());
    }

    private void ButtonClicked() {

        if(value1.getText().toString().isEmpty() || value2.getText().toString().isEmpty()){
            Toast.makeText(this,"Empty value. Please enter a value!!",Toast.LENGTH_SHORT).show();
            return;
        }
        resetOutput();
        mLogic.process();
    }

    @Override
    public double getValue1() {
        return getDoubleValueOfEditText(value1);
    }

    @Override
    public double getValue2() {
        return getDoubleValueOfEditText(value2);
    }

    @Override
    public MathOperations getSelectedOperation() {
        final String spinnerString =
                mMathSpinner.getSelectedItem().toString();
        return MathOperations.valueOf(spinnerString);
    }

    @Override
    public void resetOutput() {
        answerTextView.setText("");
    }

    @Override
    public void printOutput(String outputAnswer) {
        answerTextView.setText(outputAnswer);
    }

    private double getDoubleValueOfEditText(EditText editText){

        if(editText != null) {
            Editable valueEditable = editText.getText();
            String valueString = valueEditable.toString();
            if (!valueString.isEmpty()) {
                return Double.parseDouble(valueString);
            }
        }
        return 0;
    }
}