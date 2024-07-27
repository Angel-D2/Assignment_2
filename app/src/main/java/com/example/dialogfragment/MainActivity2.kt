package com.example.dialogfragment
import CustomDialogFragment1
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // Enable the Up button
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val feedback = intent.getStringExtra("angel")
        val ratingTV: TextView = findViewById(R.id.rateMeTextView)
        ratingTV.text = feedback

        ratingTV.setOnClickListener {
            val dialog = CustomDialogFragment1()
            dialog.show(supportFragmentManager, "Custom Dialog")
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                // Handle Up button click here
                onBackPressed()
                true
            }
            R.id.action_settings -> {
                // Handle Settings action
                true
            }
            R.id.action_about -> {
                // Handle About action
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun receiveFeedback(feedback: String) {
        val ratingTV: TextView = findViewById(R.id.rateMeTextView)
        ratingTV.text = feedback
    }
}
