// Sandro Sobczyński (s20600)

package com.example.tipper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class HealthyDietQuiz extends AppCompatActivity {

    private TextView questionTextView;
    private RadioGroup answerRadioGroup;
    private Button nextQuestionButton;

    private List<Question> questions;
    private int currentQuestionIndex;
    private int correctAnswers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.healthy_diet_quiz);

        questionTextView = findViewById(R.id.questionTextView);
        answerRadioGroup = findViewById(R.id.answerRadioGroup);
        nextQuestionButton = findViewById(R.id.nextQuestionButton);

        questions = new ArrayList<Question>();
        createQuestions();
        currentQuestionIndex = 0;
        correctAnswers = 0;

        Button returnButton = findViewById(R.id.returnButton);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HealthyDietQuiz.this, Menu.class);
                startActivity(intent);
            }
        });

        nextQuestionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedAnswerId = answerRadioGroup.getCheckedRadioButtonId();

                if (selectedAnswerId != -1) {
                    RadioButton selectedAnswer = findViewById(selectedAnswerId);
                    if (selectedAnswer.getText().equals(questions.get(currentQuestionIndex).getCorrectAnswer())) {
                        correctAnswers++;
                    }

                    currentQuestionIndex++;

                    if (currentQuestionIndex < questions.size()) {
                        displayQuestion(questions.get(currentQuestionIndex));
                    } else {
                        Intent resultIntent = new Intent(HealthyDietQuiz.this, QuizResult.class);
                        resultIntent.putExtra("correctAnswers", correctAnswers);
                        resultIntent.putExtra("totalQuestions", questions.size());
                        startActivity(resultIntent);
                        finish();
                    }
                } else {
                    Toast.makeText(HealthyDietQuiz.this, "Please select an answer", Toast.LENGTH_SHORT).show();
                }
            }
        });

        displayQuestion(questions.get(currentQuestionIndex));
    }

    private void createQuestions() {
        questions.add(new Question("What is the recommended daily fiber intake for an average adult?", "10-15 grams", "25-30 grams", "40-45 grams", "50-60 grams", "25-30 grams"));
        questions.add(new Question("Which of the following is a complete protein source for vegetarians?", "Lentils", "Quinoa", "Almonds", "Brown rice", "Quinoa"));
        questions.add(new Question("What type of fat is primarily found in olive oil?", "Saturated fat", "Polyunsaturated fat", "Trans fat", "Monounsaturated fat", "Monounsaturated fat"));
        questions.add(new Question("Which vitamin is essential for proper blood clotting?", "Vitamin A", "Vitamin D", "Vitamin E", "Vitamin K", "Vitamin K"));
        questions.add(new Question("How many essential amino acids does the human body require?", "9", "12", "20", "22", "9"));
        questions.add(new Question("Which mineral is important for maintaining strong bones and teeth?", "Iron", "Zinc", "Calcium", "Magnesium", "Calcium"));
    }

    private void displayQuestion(Question question) {
        questionTextView.setText(question.getQuestion());
        ((RadioButton) answerRadioGroup.getChildAt(0)).setText(question.getAnswer1());
        ((RadioButton) answerRadioGroup.getChildAt(1)).setText(question.getAnswer2());
        ((RadioButton) answerRadioGroup.getChildAt(2)).setText(question.getAnswer3());
        ((RadioButton) answerRadioGroup.getChildAt(3)).setText(question.getAnswer4());
        answerRadioGroup.clearCheck();
    }
}