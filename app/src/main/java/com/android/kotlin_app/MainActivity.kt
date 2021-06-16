package com.android.kotlin_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var firstName: String? = "";
        var lastName: String? = "";
        var favoriteFood: String? = "";
        var favoriteNumber: Int? = 0;


        val mainText: TextView = findViewById<TextView>(R.id.textView)
        val switchButton: Button = findViewById<Button>(R.id.button)

        if(intent.extras != null) {
            firstName = intent.getStringExtra("firstName")
            lastName = intent.getStringExtra("lastName")
            favoriteFood = intent.getStringExtra("favoriteFood")
            favoriteNumber = intent.getStringExtra("favoriteNumber")?.toInt();
            mainText.text = "So you're " + firstName + " " + lastName + ", your favorite food is " + favoriteFood + " and your favorite number is " + favoriteNumber + "."
        }


        switchButton.setOnClickListener {
            val intent = Intent(this, EditActivity::class.java)
            intent.putExtra("firstName", firstName)
            intent.putExtra("lastName", lastName)
            intent.putExtra("favoriteFood", favoriteFood)
            intent.putExtra("favoriteNumber", favoriteNumber)

            startActivity(intent)
        }

    }
}