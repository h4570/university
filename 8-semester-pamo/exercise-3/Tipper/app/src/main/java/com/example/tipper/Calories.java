// Sandro Sobczyński (s20600)

package com.example.tipper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Calories extends AppCompatActivity {

        private String selectedGender;
        private EditText weightInput;
        private EditText heightInput;
        private EditText ageInput;
        private TextView resultText;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.calories);

            Spinner genderSpinner = findViewById(R.id.gender_spinner);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.gender_array, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            genderSpinner.setAdapter(adapter);
            genderSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    selectedGender = parent.getItemAtPosition(position).toString();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });

            weightInput = findViewById(R.id.weight_input);
            heightInput = findViewById(R.id.height_input);
            ageInput = findViewById(R.id.age_input);
            resultText = findViewById(R.id.result_text);

            Button calculateButton = findViewById(R.id.calculate_button);
            calculateButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    calculateCalories();
                }
            });

            Button returnButton = findViewById(R.id.returnButton);
            returnButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Calories.this, Menu.class);
                    startActivity(intent);
                }
            });
        }

        private void calculateCalories() {
            double weight = Double.parseDouble(weightInput.getText().toString());
            double height = Double.parseDouble(heightInput.getText().toString());
            int age = Integer.parseInt(ageInput.getText().toString());

            double bmr;
            if (selectedGender.equals("Male")) {
                bmr = 88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age);
            } else {
                bmr = 447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age);
            }

            resultText.setText(String.format("Daily calories: %.2f", bmr));
        }
}