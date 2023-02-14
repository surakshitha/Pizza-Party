package com.zybooks.pizzaparty

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.ceil

/**
 * Number of Slices per pizza
 */
const val SLICES_PER_PIZZA = 8

/**
 * Main class
 */
class MainActivity : AppCompatActivity() {

    /**
     * Number of people attending the pizza party
     */
    private lateinit var numberOfPeople: EditText

    /**
     * Total pizzas calculated as per the number of people and hungry ratio
     */
    private lateinit var totalPizzas: TextView

    /**
     * The hungry ratio radio button - light, medium and ravenous
     */
    private lateinit var degreeOfHunger : RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        numberOfPeople = findViewById(R.id.number_of_people_edit_text)
        totalPizzas = findViewById(R.id.total_pizzas_text_view)
        degreeOfHunger = findViewById(R.id.hungry_ratio_radio_group)
    }

    fun calculateClick(view: View) {

        // Read th text input by the user
        // Text is of type string, convert to int
        val headCount = numberOfPeople.text.toString().toInt()

        // Calculate number of pizza slices needed per head depending on how hungry the gang is
        val slicesPerPerson = when (degreeOfHunger.checkedRadioButtonId) {
            R.id.light_radio_button -> 2
            R.id.medium_radio_button -> 3
            else -> 4
        }

        // Final calculation for the total pizzas to be bought
        val totalPizzas = ceil(headCount * slicesPerPerson / SLICES_PER_PIZZA.toDouble()).toInt()
        this.totalPizzas.text = "Total pizzas: $totalPizzas"
    }
}
