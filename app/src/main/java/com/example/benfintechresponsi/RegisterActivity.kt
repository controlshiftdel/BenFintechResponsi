package com.example.benfintechresponsi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val pencet = findViewById<Button>(R.id.btregister)
        pencet.setOnClickListener {
            val lojin= Intent(this, HomeActivity::class.java)
            startActivity(lojin)
        }
    }
}