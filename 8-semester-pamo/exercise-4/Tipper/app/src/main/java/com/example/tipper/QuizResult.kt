package com.example.tipper

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class QuizResult : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quiz_result)
        val resultsTextView = findViewById<TextView>(R.id.resultsTextView)
        val correctAnswers = intent.getIntExtra("correctAnswers", 0)
        val totalQuestions = intent.getIntExtra("totalQuestions", 0)
        resultsTextView.text = "You got $correctAnswers out of $totalQuestions correct!"
        val returnButton = findViewById<Button>(R.id.returnButton)
        returnButton.setOnClickListener {
            val intent = Intent(this@QuizResult, Menu::class.java)
            startActivity(intent)
        }
        findViewById<View>(R.id.endQuizButton).setOnClickListener { finish() }
    }
}