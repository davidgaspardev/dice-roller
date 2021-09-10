package dev.davidgapar.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        // FIST DICE
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        var diceRoll = dice.roll()

        // Update the screen with the dice roll
        var resultDice: TextView = findViewById(R.id.result_dice_1)
        resultDice.text = diceRoll.toString()

        // SECONDARY DICE
        // Roll dice again
        diceRoll = dice.roll()

        // Update the screen with the dice roll again
        resultDice = findViewById(R.id.result_dice_2)
        resultDice.text = diceRoll.toString()
    }

    class Dice(private val numSides: Int) {
        fun roll(): Int {
            return (1..numSides).random()
        }
    }
}