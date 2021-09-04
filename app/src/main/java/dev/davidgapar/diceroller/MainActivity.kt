package dev.davidgapar.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val LOG_TAG = "Main Activity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if(v !== null) {
            when(v.id) {
                R.id.button -> {
                    val textView: TextView = findViewById(R.id.textView)
                    textView.text = Dice(6).roll().toString()
                }
                else -> {
                    Log.i(LOG_TAG, "Don't have onClick event to id: ${v.id}")
                }
            }
        }
    }

    class Dice(private val numSides: Int) {
        fun roll(): Int {
            return (1..numSides).random()
        }
    }
}