package com.example.kotlinjourney1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class ConstraintLayout : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint_layout)

        val mail : TextView = findViewById(R.id.mail)
        val image : ImageView = findViewById(R.id.image)
        val btn : Button = findViewById(R.id.btn)
        val pass : TextView = findViewById(R.id.pass)
        mail.text = intent.getStringExtra("email")
        pass. text = intent.getStringExtra("password")

        btn.setOnClickListener {
            image.setImageResource(R.drawable.pp1)
        }
    }
}