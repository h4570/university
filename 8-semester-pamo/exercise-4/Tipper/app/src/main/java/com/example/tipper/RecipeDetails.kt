// Sandro Sobczyński (s20600)
package com.example.tipper

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RecipeDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recipe_details)
        val recipeDetailsTextView = findViewById<TextView>(R.id.recipeDetailsTextView)
        val intent = intent
        val recipeText = intent.getStringExtra("recipeText")
        if (recipeText != null && !recipeText.isEmpty()) {
            recipeDetailsTextView.text = recipeText
        } else {
            recipeDetailsTextView.text = "Brak szczegółów przepisu"
        }
        val returnButton = findViewById<Button>(R.id.returnButton)
        returnButton.setOnClickListener {
            val intent = Intent(this@RecipeDetails, Eat::class.java)
            startActivity(intent)
        }
    }
}