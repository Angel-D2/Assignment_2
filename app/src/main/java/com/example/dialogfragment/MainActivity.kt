package com.example.dialogfragment

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import CustomDialogFragment
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button_start_second_activity)
        button.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java).apply {
                putExtra("angel", " Click me for a suprise question")
            }
            startActivity(intent)
        }

        val ratingTV: TextView = findViewById(R.id.rateMeTextView)
        ratingTV.setOnClickListener {
            val dialog = CustomDialogFragment()
            dialog.show(supportFragmentManager, "Custom Dialog")
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return true
    }


    fun receiveFeedback(feedback: String) {
        val ratingTV: TextView = findViewById(R.id.rateMeTextView)
        ratingTV.text = feedback
    }
}
