// Sandro Sobczyński (s20600)
package com.example.tipper

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener
import androidx.appcompat.app.AppCompatActivity

class Calories : AppCompatActivity() {
    private var selectedGender: String? = null
    private var weightInput: EditText? = null
    private var heightInput: EditText? = null
    private var ageInput: EditText? = null
    private var resultText: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calories)
        val genderSpinner = findViewById<Spinner>(R.id.gender_spinner)
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.gender_array, android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        genderSpinner.adapter = adapter
        genderSpinner.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                selectedGender = parent.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        weightInput = findViewById(R.id.weight_input)
        heightInput = findViewById(R.id.height_input)
        ageInput = findViewById(R.id.age_input)
        resultText = findViewById(R.id.result_text)
        val calculateButton = findViewById<Button>(R.id.calculate_button)
        calculateButton.setOnClickListener { calculateCalories() }
        val returnButton = findViewById<Button>(R.id.returnButton)
        returnButton.setOnClickListener {
            val intent = Intent(this@Calories, Menu::class.java)
            startActivity(intent)
        }
    }

    private fun calculateCalories() {
        val weight = weightInput!!.text.toString().toDouble()
        val height = heightInput!!.text.toString().toDouble()
        val age = ageInput!!.text.toString().toInt()
        val bmr: Double
        bmr = if (selectedGender == "Male") {
            88.362 + 13.397 * weight + 4.799 * height - 5.677 * age
        } else {
            447.593 + 9.247 * weight + 3.098 * height - 4.330 * age
        }
        resultText!!.text = String.format("Daily calories: %.2f", bmr)
    }
}