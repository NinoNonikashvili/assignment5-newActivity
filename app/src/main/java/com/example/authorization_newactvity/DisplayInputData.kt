package com.example.authorization_newactvity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DisplayInputData : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_input_data)

        val firstname = intent.getStringExtra(EXTRA_MESSAGE1)
        val lastname = intent.getStringExtra(EXTRA_MESSAGE2)
        val email = intent.getStringExtra(EXTRA_MESSAGE3)
        val age = intent.getStringExtra(EXTRA_MESSAGE4)
        val data1 = findViewById<TextView>(R.id.firstNameData).apply{
            text = "first name: $firstname"
        }
        val data2 = findViewById<TextView>(R.id.lastNameData).apply{
            text = "last name: $lastname"
        }
        val data3 = findViewById<TextView>(R.id.emailData).apply{
            text = "email: $email"
        }
        val data4 = findViewById<TextView>(R.id.ageData).apply{
            text = "age: $age"
        }
    }
}