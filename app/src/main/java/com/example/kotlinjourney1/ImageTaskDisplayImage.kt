package com.example.kotlinjourney1

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso

class ImageTaskDisplayImage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_task_display_image)

        var bigImage : ImageView = findViewById(R.id.bigImage)
        var bigImageDetail : TextView = findViewById(R.id.bigImageDetail)
        val imageUrl : String? = intent.getStringExtra("url")
        Picasso.get().load(imageUrl).into(bigImage)
        bigImageDetail.text = "Image Url : " + imageUrl
    }
}