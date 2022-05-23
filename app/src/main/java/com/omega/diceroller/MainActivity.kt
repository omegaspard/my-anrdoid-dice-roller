package com.omega.diceroller

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.v(TAG, "Create Dice.")
        val dice = Dice(6)
        Log.v(TAG, "Create DiceThrower instance.")
        val diceThrower = DiceThrower(dice)

        findViewById<ImageView>(R.id.imageView2).setImageResource(R.drawable.dice_1)
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            val diceImage: ImageView = findViewById(R.id.imageView2)
            Log.v(TAG, "Roll the dice.")
            dice.roll()
            diceThrower.displaySide(diceImage)

            val toast = Toast.makeText(this, "Dice rolled !", Toast.LENGTH_SHORT)
            toast.show();
        }
    }
}

class DiceThrower(private val dice: Dice) {
    init {
        if(dice.numSides != 6) {
            Log.e("DiceThrower", "Only support dices with 6 sides !")
            assert(dice.numSides != 6)
        }
    }

    fun displaySide(rollUpdated: ImageView) {
        when(dice.getLastResult()) {
            1 ->   rollUpdated.setImageResource(R.drawable.dice_1)
            2 ->   rollUpdated.setImageResource(R.drawable.dice_2)
            3 ->   rollUpdated.setImageResource(R.drawable.dice_3)
            4 ->   rollUpdated.setImageResource(R.drawable.dice_4)
            5 ->   rollUpdated.setImageResource(R.drawable.dice_5)
            6 ->   rollUpdated.setImageResource(R.drawable.dice_6)
        }
    }
}

class Dice(val numSides: Int) {
    private var lastRollResult: Int? = null

    fun roll() {
        lastRollResult = (1..numSides).random()
    }

    fun getLastResult(): Int {
        return this.let { lastRollResult!! }
    }
}
