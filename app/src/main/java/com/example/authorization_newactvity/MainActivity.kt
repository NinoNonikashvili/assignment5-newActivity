package com.example.authorization_newactvity

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doOnTextChanged
import com.example.authorization_newactvity.databinding.ActivityMainBinding
import android.text.TextUtils
import android.util.Patterns
import android.view.View
import android.util.Log
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText


const val EXTRA_MESSAGE1 = "FIRST_NAME"
const val EXTRA_MESSAGE2 = "LAST_NAME"
const val EXTRA_MESSAGE3 = "EMAL"
const val EXTRA_MESSAGE4 = "AGE"

class MainActivity : AppCompatActivity()  {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btn = binding.login
        val doOnTextChanged = binding.email.doOnTextChanged { text, start, before, count ->
            if (isValidEmail(binding.email.text.toString()))
                success(binding.email)
            else
                fail(binding.email)
        }



        }

    fun isValidEmail(target: CharSequence?): Boolean {
        return if (TextUtils.isEmpty(target)) {
            false
        } else
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches()
    }
    fun success(comp:AppCompatEditText){
        comp.setTextColor(Color.GREEN)
    }
    fun fail(comp:AppCompatEditText){
        comp.setTextColor(Color.RED)
        Toast.makeText(this, "enter valid email", Toast.LENGTH_SHORT).show()
    }

    fun newActivity(view: View) {
        val message1 = binding.firstName.text.toString()
        val message2 = binding.lastName.text.toString()
        val message3 = binding.email.text.toString()
        val message4 = binding.age.text.toString()
        val intent = Intent(this, DisplayInputData::class.java).apply{
            putExtra(EXTRA_MESSAGE1, message1)}
        intent.apply{ putExtra(EXTRA_MESSAGE2, message2 )}
        intent.apply{ putExtra(EXTRA_MESSAGE3, message3 )}
        intent.apply{ putExtra(EXTRA_MESSAGE4, message4 )}

        startActivity(intent)
    }

}