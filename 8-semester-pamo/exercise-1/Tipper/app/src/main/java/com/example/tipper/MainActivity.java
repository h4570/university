package com.example.tipper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable; // for EditText event handling
import android.text.TextWatcher; // EditText listener
import android.widget.EditText; // for bill amount input
import android.widget.TextView; // for displaying text

import java.text.NumberFormat; // for currency formatting

public class MainActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_main); // inflate the GUI

        weightTextView = (TextView) findViewById(R.id.weightTextView);
        heightTextView = (TextView) findViewById(R.id.heightTextView);
        resultTextView = (TextView) findViewById(R.id.resultTextView);

        // set amountEditText's TextWatcher
        EditText field1 = (EditText) findViewById(R.id.weightEditText);
        field1.addTextChangedListener(weightEditTextWatcher);

        EditText field2 = (EditText) findViewById(R.id.heightEditText);
        field2.addTextChangedListener(heightEditTextWatcher);
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


/*************************************************************************
 * (C) Copyright 1992-2016 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
