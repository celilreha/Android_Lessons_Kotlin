package com.celilreha.kotlin_001

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    lateinit var diceText : TextView
    lateinit var diceButton: Button
    lateinit var button: Button
    lateinit var editText: EditText
    lateinit var diceImage : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        diceText = findViewById(R.id.textView)
        diceButton = findViewById(R.id.button)
        diceImage = findViewById(R.id.imageView)
        button = findViewById(R.id.button2)
        editText = findViewById(R.id.editText)

        diceButton.setOnClickListener {
            changeText()
        }
        button.setOnClickListener {
            sendText()
        }

    }
    private fun sendText(){
        val intent = Intent(this,SecondActivity::class.java)
        intent.putExtra("send",editText.text.toString())
        startActivity(intent)
    }
    private fun changeText(){
        val randomNumber = (1..6).random()
        val drawable = when(randomNumber){
            1 -> R.drawable.dice1
            2 -> R.drawable.dice2
            3 -> R.drawable.dice3
            4 -> R.drawable.dice4
            5 -> R.drawable.dice5
            else -> R.drawable.dice6
        }
        diceImage.setImageResource(drawable)
        diceText.text = randomNumber.toString()
        Toast.makeText(this,"Number: ${diceText.text}",Toast.LENGTH_SHORT).show()
    }


}