package com.example.assignment1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast" , "MissingInflatedId" , "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get UI components
        val timeText = findViewById<EditText>(R.id.timeOfDay) // EditText for entering time of day
        val mealText = findViewById<TextView>(R.id.foodText) // TextView for displaying meal suggestions
        val resetButton = findViewById<Button>(R.id.button2) // Button to reset input and output
        val submitButton = findViewById<Button>(R.id.insertButton) // Button to submit input and get meal suggestions

        // Reset button functionality
        resetButton.setOnClickListener {
            timeText.text.clear()
            mealText.text = ""
        }

        // Meal suggestions
        val suggestions = mapOf(
            "Morning" to "Scrambled Eggs with Toast Serve with butter or avocado, Pancakes or Waffles and top with maple syrup with whipped cream, Banana and Peanut Butter, French Toast ",
            "Mid-Morning" to "Cottage Cheese with Fruit or Nuts, Whole Wheat Toast with Peanut Butter, Granola Bar or Protein Bar, Smoothie",
            "Afternoon" to "Grilled Chicken Salad, Grilled Veggie Sandwich, Rice Cakes with Peanut Butter and Banana, Cheese and Whole Grain Crackers, Hummus with Pita Bread and Veggies",
            "Mid-Afternoon" to "Cheese sandwich, Pizza, Sushi, Chicken or Tofu Stir-Fry, Greek Salad ",
            "Night" to "Roast Chicken with Veggies, Beef or Veggie Chili, Crispy Chickpea Salad, Fried Chicken with Mac and Cheese, Lasagna",
            "Dessert" to "Red Velvet Cake, Carrot Cake, Waffles with Ice Cream, Banana Split, Pudding"
        )

        // Submit button functionality
        submitButton.setOnClickListener {
            val inputText = timeText.text.toString().trim()

            if (inputText.isEmpty()) {
                Toast.makeText(this, "Please enter a time of day", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (inputText in suggestions) {
                mealText.text = "Suggestions: ${suggestions[inputText]}"
            } else {
                Toast.makeText(this, "Invalid time of day. Try Morning, Mid-Morning, Afternoon, etc.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
