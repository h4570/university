// Sandro Sobczyński (s20600)
package com.example.tipper

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Eat : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.eat)
        val recipe1Button = findViewById<Button>(R.id.recipe1Button)
        val recipe2Button = findViewById<Button>(R.id.recipe2Button)
        val recipe3Button = findViewById<Button>(R.id.recipe3Button)
        val returnButton = findViewById<Button>(R.id.returnButton)
        recipe1Button.setOnClickListener { showRecipeDetails(1) }
        recipe2Button.setOnClickListener { showRecipeDetails(2) }
        recipe3Button.setOnClickListener { showRecipeDetails(3) }
        returnButton.setOnClickListener {
            val intent = Intent(this@Eat, Menu::class.java)
            startActivity(intent)
        }
    }

    private fun showRecipeDetails(recipeNumber: Int) {
        val intent = Intent(this@Eat, RecipeDetails::class.java)
        val recipeText = getRecipeFromDatabase(recipeNumber)
        intent.putExtra("recipeText", recipeText)
        startActivity(intent)
    }

    private fun getRecipeFromDatabase(i: Int): String {
        return when (i) {
            1 -> """
                Tomato and Basil Bruschetta.
                
                Ingredients:
                - 1 baguette, sliced
                - 3 medium tomatoes, diced
                - 1/4 cup fresh basil, chopped
                - 2 cloves garlic, minced
                - 2 tbsp olive oil
                - Salt and pepper, to taste
                
                Instructions:
                1. Combine tomatoes, basil, garlic, olive oil, salt, and pepper in a bowl.
                2. Toast the baguette slices until golden.
                3. Top each toasted slice with the tomato mixture and serve.
                """.trimIndent()
            2 -> """
                Quick Veggie Stir-Fry.
                
                Ingredients:
                - 1 cup heavy cream
                - 1 cup semi-sweet chocolate chips
                - 1/4 cup powdered sugar
                - 1 tsp vanilla extract
                
                Instructions:
                1. Melt chocolate chips in a microwave or double boiler.
                2. Whip heavy cream with powdered sugar and vanilla extract until stiff peaks form.
                3. Gently fold melted chocolate into whipped cream mixture.
                4. Spoon mousse into individual servings and chill for at least 2 hours before serving.
                """.trimIndent()
            else -> """
                Simple Lemon Pasta.
                
                Ingredients:
                - 8 oz spaghetti or linguine
                - 1/4 cup olive oil
                - 2 cloves garlic, minced
                - Zest and juice of 1 lemon
                - 1/4 cup grated Parmesan cheese
                - 1/4 cup fresh parsley, chopped
                - Salt and pepper, to taste
                
                Instructions:
                1. Cook pasta according to package instructions, reserving 1/4 cup of pasta water.
                2. In a large skillet, heat olive oil over medium heat. Add garlic and cook for 1-2 minutes until fragrant.
                3. Add lemon zest and juice to the skillet, stirring to combine.
                4. Drain pasta and add it to the skillet, tossing to coat with the lemon sauce. Add a bit of reserved pasta water to help create a smooth sauce.
                5. Stir in Parmesan cheese and chopped parsley. Season with salt and pepper, to taste.
                6. Serve immediately, with extra Parmesan cheese and lemon wedges, if desired.
                """.trimIndent()
        }
    }
}