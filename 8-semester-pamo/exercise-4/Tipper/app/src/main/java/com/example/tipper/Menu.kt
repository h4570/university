// Sandro Sobczyński (s20600)
package com.example.tipper

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu)
        val bmiButton = findViewById<Button>(R.id.bmiButton)
        bmiButton.setOnClickListener {
            val intent = Intent(this@Menu, BMI::class.java)
            startActivity(intent)
        }
        val caloriesButton = findViewById<Button>(R.id.caloriesButton)
        caloriesButton.setOnClickListener {
            val intent = Intent(this@Menu, Calories::class.java)
            startActivity(intent)
        }
        val eatButton = findViewById<Button>(R.id.eatButton)
        eatButton.setOnClickListener {
            val intent = Intent(this@Menu, Eat::class.java)
            startActivity(intent)
        }
        val quizButton = findViewById<Button>(R.id.quizButton)
        quizButton.setOnClickListener {
            val intent = Intent(this@Menu, HealthyDietQuiz::class.java)
            startActivity(intent)
        }
        val chartButton = findViewById<Button>(R.id.chartButton)
        chartButton.setOnClickListener {
            val intent = Intent(this@Menu, BMIChart::class.java)
            startActivity(intent)
        }
        val returnButton = findViewById<Button>(R.id.returnButton)
        returnButton.setOnClickListener {
            val intent = Intent(this@Menu, Start::class.java)
            startActivity(intent)
        }
    }
}