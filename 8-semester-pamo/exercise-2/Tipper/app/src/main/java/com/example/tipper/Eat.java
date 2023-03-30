// Sandro Sobczyński (s20600)

package com.example.tipper;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;

public class Eat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eat);

        Button recipe1Button = findViewById(R.id.recipe1Button);
        Button recipe2Button = findViewById(R.id.recipe2Button);
        Button recipe3Button = findViewById(R.id.recipe3Button);
        Button returnButton = findViewById(R.id.returnButton);

        recipe1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRecipeDetails(1);
            }
        });

        recipe2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRecipeDetails(2);
            }
        }); recipe3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRecipeDetails(3);
            }
        });

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Eat.this, Menu.class);
                startActivity(intent);
            }
        });
    }

    private void showRecipeDetails(int recipeNumber) {
        Intent intent = new Intent(Eat.this, RecipeDetails.class);
        String recipeText = getRecipeFromDatabase(recipeNumber);
        intent.putExtra("recipeText", recipeText);
        startActivity(intent);
    }

    private String getRecipeFromDatabase(int i){
        switch (i) {
            case 1:
                return "Tomato and Basil Bruschetta.\n" +
                        "\n" +
                        "Ingredients:\n" +
                        "- 1 baguette, sliced\n" +
                        "- 3 medium tomatoes, diced\n" +
                        "- 1/4 cup fresh basil, chopped\n" +
                        "- 2 cloves garlic, minced\n" +
                        "- 2 tbsp olive oil\n" +
                        "- Salt and pepper, to taste\n" +
                        "\n" +
                        "Instructions:\n" +
                        "1. Combine tomatoes, basil, garlic, olive oil, salt, and pepper in a bowl.\n" +
                        "2. Toast the baguette slices until golden.\n" +
                        "3. Top each toasted slice with the tomato mixture and serve.";
            case 2:
                return "Quick Veggie Stir-Fry.\n" +
                        "\n" +
                        "Ingredients:\n" +
                        "- 1 cup heavy cream\n" +
                        "- 1 cup semi-sweet chocolate chips\n" +
                        "- 1/4 cup powdered sugar\n" +
                        "- 1 tsp vanilla extract\n" +
                        "\n" +
                        "Instructions:\n" +
                        "1. Melt chocolate chips in a microwave or double boiler.\n" +
                        "2. Whip heavy cream with powdered sugar and vanilla extract until stiff peaks form.\n" +
                        "3. Gently fold melted chocolate into whipped cream mixture.\n" +
                        "4. Spoon mousse into individual servings and chill for at least 2 hours before serving.";
            default:
                return "Simple Lemon Pasta.\n" +
                        "\n" +
                        "Ingredients:\n" +
                        "- 8 oz spaghetti or linguine\n" +
                        "- 1/4 cup olive oil\n" +
                        "- 2 cloves garlic, minced\n" +
                        "- Zest and juice of 1 lemon\n" +
                        "- 1/4 cup grated Parmesan cheese\n" +
                        "- 1/4 cup fresh parsley, chopped\n" +
                        "- Salt and pepper, to taste\n" +
                        "\n" +
                        "Instructions:\n" +
                        "1. Cook pasta according to package instructions, reserving 1/4 cup of pasta water.\n" +
                        "2. In a large skillet, heat olive oil over medium heat. Add garlic and cook for 1-2 minutes until fragrant.\n" +
                        "3. Add lemon zest and juice to the skillet, stirring to combine.\n" +
                        "4. Drain pasta and add it to the skillet, tossing to coat with the lemon sauce. Add a bit of reserved pasta water to help create a smooth sauce.\n" +
                        "5. Stir in Parmesan cheese and chopped parsley. Season with salt and pepper, to taste.\n" +
                        "6. Serve immediately, with extra Parmesan cheese and lemon wedges, if desired.";
        }
    }
}