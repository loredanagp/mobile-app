package com.android.kotlin_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class EditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        // INCOMING VALUES FROM PREVIOUS INTENT
        val first: String? = intent.getStringExtra("firstName")
        val last: String? = intent.getStringExtra("lastName")
        val food: String? = intent.getStringExtra("favoriteFood")
        val number: Int = intent.getIntExtra("favoriteNumber", 0)

        // TEXT MAP TO VALUES
        val firstName: TextView = findViewById(R.id.firstName)
        val lastName: TextView = findViewById(R.id.lastName)
        val favoriteFood: TextView = findViewById(R.id.favoriteFood)
        val favoriteNumber: TextView = findViewById(R.id.favoriteNumber)
        val goBackBtn: Button = findViewById(R.id.goback)
        val warning: TextView = findViewById(R.id.warning)

        firstName.text = first
        lastName.text = last
        favoriteFood.text = food
        favoriteNumber.text = number.toString()

        goBackBtn.setOnClickListener {
            if(firstName.text.toString() == "" || lastName.text.toString() == "" || favoriteFood.text.toString() == "") {
                println(first)
                warning.text = "please fill all the missing fields <3"
            } else {
                println(firstName.text)
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("firstName", firstName.text.toString())
                intent.putExtra("lastName", lastName.text.toString())
                intent.putExtra("favoriteFood", favoriteFood.text.toString())
                intent.putExtra("favoriteNumber", favoriteNumber.text.toString())

                startActivity(intent)
            }
        }
    }
}