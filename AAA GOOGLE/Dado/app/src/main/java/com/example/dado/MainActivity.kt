package com.example.dado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {   //metodo principale come se fosse main
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)

        rollButton.setOnClickListener {
            //Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()
            println("ciao22")                                   //per stampare nella console run
            rollDice()

        }
    }

    private fun rollDice() {
        val dice=Dado(6)
        val diceRoll=dice.roll()

        val text:TextView=findViewById(R.id.textView)
        text.text=diceRoll.toString()

        val imagine : ImageView=findViewById(R.id.imageView)
       // imagine.setImageResource(R.drawable.dice_3)     //cosi prendo le immaggini e le setto
        /**
         *  when e una specie di else if
         */
        when(diceRoll){
            1 -> imagine.setImageResource(R.drawable.dice_1)
            2->imagine.setImageResource(R.drawable.dice_2)
            3->imagine.setImageResource(R.drawable.dice_3)
            4->imagine.setImageResource(R.drawable.dice_4)
            5->imagine.setImageResource(R.drawable.dice_5)
            6->imagine.setImageResource(R.drawable.dice_6)

        }
    }
}

class Dado(val n_lati: Int){
    fun roll(): Int{

        return (1..n_lati).random()
    }
}