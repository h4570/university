// Sandro Sobczyński (s20600)

package com.example.tipper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

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
                        "- 1 baguette, sliced\n";
            case 2:
                return "Quick Veggie Stir-Fry.\n" +
                        "\n" +
                        "Ingredients:\n" +
                        "- 1 cup heavy cream\n";
            default:
                return "Simple Lemon Pasta.\n" +
                        "\n" +
                        "Ingredients:\n" +
                        "- 8 oz spaghetti or linguine\n";
        }
    }
}