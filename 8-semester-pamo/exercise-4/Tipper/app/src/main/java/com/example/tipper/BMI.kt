package com.example.tipper

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.NumberFormat

/**
 * Author Sandro Sobczyński s20600
 */
class BMI : AppCompatActivity() {

    private val formatter = NumberFormat.getNumberInstance()

    private var userWeight = 0.000
    private var userHeight = 0.0

    private var weightTextView: TextView? = null
    private var heightTextView: TextView? = null
    private var resultTextView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bmi)

        weightTextView = findViewById(R.id.weightTextView)
        heightTextView = findViewById(R.id.heightTextView)
        resultTextView = findViewById(R.id.resultTextView)

        val field1 = findViewById<EditText>(R.id.weightEditText)
        field1.addTextChangedListener(weightEditTextWatcher)

        val field2 = findViewById<EditText>(R.id.heightEditText)
        field2.addTextChangedListener(heightEditTextWatcher)

        val returnButton = findViewById<Button>(R.id.returnButton)
        returnButton.setOnClickListener {
            val intent = Intent(this@BMI, Menu::class.java)
            startActivity(intent)
        }
    }

    private fun calculate() {
        val result = userWeight / Math.pow(userHeight / 100.0, 2.0)
        resultTextView?.text = formatter.format(result)
    }

    private val heightEditTextWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable) {}

        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            try {
                userHeight = s.toString().toDouble()
                heightTextView?.text = formatter.format(userHeight)
            } catch (e: NumberFormatException) {
                heightTextView?.text = ""
                userHeight = 0.0
            }
            calculate()
        }
    }

    private val weightEditTextWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable) {}

        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            try {
                userWeight = s.toString().toDouble()
                weightTextView?.text = formatter.format(userWeight)
            } catch (e: NumberFormatException) {
                weightTextView?.text = ""
                userWeight = 0.0
            }
            calculate()
        }
    }
}