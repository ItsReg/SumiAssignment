package com.example.sumiassignment

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val iv = findViewById<ImageView>(R.id.detailImageView)
        val title = findViewById<TextView>(R.id.detailTvTitle)
        val description = findViewById<TextView>(R.id.detailTvDescription)

        title.text = intent.getStringExtra("title")
        description.text = intent.getStringExtra("albumid")
        Glide.with(iv.context).load(intent.getStringExtra("imageurl")).centerCrop().into(iv)
    }
}
