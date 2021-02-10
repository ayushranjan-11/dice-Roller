package com.example.learningwithgoogle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)


        rollButton.setOnClickListener {
            val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
            toast.show()
            rollDice(6)
            rollDice2(12)
        }
    }

    private fun rollDice2(number2:Int) {
        val diceRoll2=Dice(number2)
        val abcd2=diceRoll2.diceRoll()
    }

    //Function to call dice roll algorithm
     fun rollDice(numbers:Int) {
        val dice = Dice(numbers) //Dice class object Instance
        val abcd = dice.diceRoll() //calling function of class through reference
        val diceImage: ImageView = findViewById(R.id.imageView)

       val drawableResource= when(abcd) {
            1-> R.drawable.dice_1
            2-> R.drawable.dice_2
            3-> R.drawable.dice_3
            4-> R.drawable.dice_4
            5-> R.drawable.dice_5
           else-> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
        /*Ye upar wala tarika thoda smart likhne wla hai,nahi to jo normal tha usse bhi kaam chal jaayega
        when(abcd) {
            1-> diceImage.setImageResource(R.drawable.dice_1)
            2-> diceImage.setImageResource(R.drawable.dice_2)
            3-> diceImage.setImageResource(R.drawable.dice_3)
            4-> diceImage.setImageResource(R.drawable.dice_4)
            5-> diceImage.setImageResource(R.drawable.dice_5)
            6-> diceImage.setImageResource(R.drawable.dice_6)
        }
         */

    }
}

//Actual dice roll work does here
class Dice(val diceSide: Int) {
    fun diceRoll(): Int {
        return (1..diceSide).random()

    }
}