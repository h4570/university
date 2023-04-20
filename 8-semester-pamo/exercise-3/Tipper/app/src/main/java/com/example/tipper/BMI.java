// Sandro Sobczyński (s20600)

package com.example.tipper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class BMI extends AppCompatActivity {

    private static final NumberFormat formatter = NumberFormat.getNumberInstance();

    private double userWeight = 0.000;
    private double userHeight = 0;

    private TextView weightTextView;
    private TextView heightTextView;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi);

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