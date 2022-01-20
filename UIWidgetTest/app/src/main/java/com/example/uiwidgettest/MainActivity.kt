package com.example.uiwidgettest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button:Button=findViewById(R.id.button)
        button.setOnClickListener{
            Toast.makeText(this,editText.text.toString(),Toast.LENGTH_SHORT).show()
            imageView.setImageResource(R.drawable.img2)
        }
    }
}