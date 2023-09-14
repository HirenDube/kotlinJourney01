package com.example.kotlinjourney1

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


class LinearLayout : AppCompatActivity() {
    @SuppressLint("CutPasteId", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_linear_layout)

        val name : EditText = findViewById(R.id.nameBox)
        val email : EditText = findViewById(R.id.emailBox)
        val password : EditText = findViewById(R.id.passwordBox)
        val submit : Button = findViewById(R.id.signUpButton)
        val attemptDisplayer : TextView = findViewById(R.id.attemptsLeft)
        var attemptsLeft : Int = 5;
        submit.setOnClickListener {
            if(name.text.isNotEmpty() && email.text.isNotEmpty() && password.text.isNotEmpty() && attemptsLeft >= 1 ){
                Toast.makeText(this,"Sing Up Success",Toast.LENGTH_SHORT).show()
                var next : Intent = Intent(this,MainActivity::class.java)
                next.putExtra("email",email.text.toString())
                next.putExtra("password",password.text.toString())
                startActivity(next)
                }else if (attemptsLeft>0){
                attemptsLeft--;
                Toast.makeText(this,"Sing Up Failed",Toast.LENGTH_SHORT).show()
                attemptDisplayer.text = "No. of attempts left : $attemptsLeft"

            }
        }


    }
}