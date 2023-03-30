// Sandro Sobczyński (s20600)

package com.example.tipper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable; // for EditText event handling
import android.text.TextWatcher; // EditText listener
import android.view.View;
import android.widget.Button;
import android.widget.EditText; // for bill amount input
import android.widget.TextView; // for displaying text

import java.text.NumberFormat; // for currency formatting

public class BMI extends AppCompatActivity {

    private static final NumberFormat formatter = NumberFormat.getNumberInstance();

    private double userWeight = 0.000;
    private double userHeight = 0;

    private TextView weightTextView; // shows formatted bill amount
    private TextView heightTextView; // shows formatted bill amount
    private TextView resultTextView; // shows calculated total bill amount

    // called when the activity is first created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // call superclass onCreate
        setContentView(R.layout.bmi); // inflate the GUI

        weightTextView = (TextView) findViewById(R.id.weightTextView);
        heightTextView = (TextView) findViewById(R.id.heightTextView);
        resultTextView = (TextView) findViewById(R.id.resultTextView);

        // set amountEditText's TextWatcher
        EditText field1 = (EditText) findViewById(R.id.weightEditText);
        field1.addTextChangedListener(weightEditTextWatcher);

        EditText field2 = (EditText) findViewById(R.id.heightEditText);
        field2.addTextChangedListener(heightEditTextWatcher);

        Button returnButton = findViewById(R.id.returnButton);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BMI.this, Menu.class);
                startActivity(intent);
            }
        });
    }

    private void calculate() {
        double result = userWeight / Math.pow(userHeight / 100.0, 2);
        resultTextView.setText(formatter.format(result));
    }

    private final TextWatcher heightEditTextWatcher = new TextWatcher() {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try {
                userHeight = Double.parseDouble(s.toString());
                heightTextView.setText(formatter.format(userHeight));
            }
            catch (NumberFormatException e) {
                heightTextView.setText("");
                userHeight = 0;
            }
            calculate();
        }

        @Override
        public void afterTextChanged(Editable s) { }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
    };

    private final TextWatcher weightEditTextWatcher = new TextWatcher() {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try {
                userWeight = Double.parseDouble(s.toString());
                weightTextView.setText(formatter.format(userWeight));
            }
            catch (NumberFormatException e) {
                weightTextView.setText("");
                userWeight = 0.0;
            }
            calculate();
        }

        @Override
        public void afterTextChanged(Editable s) { }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
    };
}