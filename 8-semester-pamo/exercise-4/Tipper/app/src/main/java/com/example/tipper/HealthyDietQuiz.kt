// Sandro Sobczyński (s20600)
package com.example.tipper

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class HealthyDietQuiz : AppCompatActivity() {
    private var questionTextView: TextView? = null
    private var answerRadioGroup: RadioGroup? = null
    private var nextQuestionButton: Button? = null
    private var questions: MutableList<Question>? = null
    private var currentQuestionIndex = 0
    private var correctAnswers = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.healthy_diet_quiz)
        questionTextView = findViewById(R.id.questionTextView)
        answerRadioGroup = findViewById(R.id.answerRadioGroup)
        nextQuestionButton = findViewById(R.id.nextQuestionButton)
        questions = ArrayList()
        createQuestions()
        currentQuestionIndex = 0
        correctAnswers = 0
        val returnButton = findViewById<Button>(R.id.returnButton)
        returnButton.setOnClickListener {
            val intent = Intent(this@HealthyDietQuiz, Menu::class.java)
            startActivity(intent)
        }
        nextQuestionButton?.setOnClickListener(View.OnClickListener {
            val selectedAnswerId = answerRadioGroup!!.getCheckedRadioButtonId()
            if (selectedAnswerId != -1) {
                val selectedAnswer = findViewById<RadioButton>(selectedAnswerId!!)
                if (selectedAnswer.text == questions?.get(currentQuestionIndex)!!.correctAnswer) {
                    correctAnswers++
                }
                currentQuestionIndex++
                if (currentQuestionIndex < questions!!.size) {
                    displayQuestion(questions!!.get(currentQuestionIndex))
                } else {
                    val resultIntent = Intent(this@HealthyDietQuiz, QuizResult::class.java)
                    resultIntent.putExtra("correctAnswers", correctAnswers)
                    resultIntent.putExtra("totalQuestions", questions?.size)
                    startActivity(resultIntent)
                    finish()
                }
            } else {
                Toast.makeText(this@HealthyDietQuiz, "Please select an answer", Toast.LENGTH_SHORT)
                    .show()
            }
        })
        displayQuestion(questions!!.get(currentQuestionIndex))
    }

    private fun createQuestions() {
        questions!!.add(
            Question(
                "What is the recommended daily fiber intake for an average adult?",
                "10-15 grams",
                "25-30 grams",
                "40-45 grams",
                "50-60 grams",
                "25-30 grams"
            )
        )
        questions!!.add(
            Question(
                "Which of the following is a complete protein source for vegetarians?",
                "Lentils",
                "Quinoa",
                "Almonds",
                "Brown rice",
                "Quinoa"
            )
        )
        questions!!.add(
            Question(
                "What type of fat is primarily found in olive oil?",
                "Saturated fat",
                "Polyunsaturated fat",
                "Trans fat",
                "Monounsaturated fat",
                "Monounsaturated fat"
            )
        )
        questions!!.add(
            Question(
                "Which vitamin is essential for proper blood clotting?",
                "Vitamin A",
                "Vitamin D",
                "Vitamin E",
                "Vitamin K",
                "Vitamin K"
            )
        )
        questions!!.add(
            Question(
                "How many essential amino acids does the human body require?",
                "9",
                "12",
                "20",
                "22",
                "9"
            )
        )
        questions!!.add(
            Question(
                "Which mineral is important for maintaining strong bones and teeth?",
                "Iron",
                "Zinc",
                "Calcium",
                "Magnesium",
                "Calcium"
            )
        )
    }

    private fun displayQuestion(question: Question) {
        questionTextView!!.text = question.question
        (answerRadioGroup!!.getChildAt(0) as RadioButton).text = question.answer1
        (answerRadioGroup!!.getChildAt(1) as RadioButton).text = question.answer2
        (answerRadioGroup!!.getChildAt(2) as RadioButton).text = question.answer3
        (answerRadioGroup!!.getChildAt(3) as RadioButton).text = question.answer4
        answerRadioGroup!!.clearCheck()
    }
}