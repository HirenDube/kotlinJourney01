package com.example.kotlinjourney1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.lang.Exception
import java.lang.NullPointerException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mail: EditText = findViewById(R.id.editTextTextEmailAddress)
        val password: EditText = findViewById(R.id.editTextTextPassword)
        val submitBTN: Button = findViewById(R.id.submit)
//        Toast.makeText(this, "Every thing is safe and sound", Toast.LENGTH_SHORT)

        submitBTN.setOnClickListener {
            try {
                if (intent.getStringExtra("email")!! == mail.text.toString() &&
                    intent.getStringExtra("password")!! == password.text.toString()
                ) {
                    Toast.makeText(this, "Login Successfull", Toast.LENGTH_SHORT).show()
                    var nextAgain : Intent = Intent(this,ConstraintLayout::class.java)
                    nextAgain.putExtra("email",mail.text.toString())
                    nextAgain.putExtra("password",password.text.toString())
                    startActivity(nextAgain)

                } else {
                    Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()

                }
            } catch (e: NullPointerException) {

                Toast.makeText(this, "$e", Toast.LENGTH_SHORT).show()
            }
//            Toast.makeText(this,mail.text, Toast.LENGTH_LONG,).show()
//            Toast.makeText(this,password.text, Toast.LENGTH_SHORT,).show()

        }

    }
}