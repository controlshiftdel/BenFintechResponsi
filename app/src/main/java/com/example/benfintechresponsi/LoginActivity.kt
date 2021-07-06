package com.example.benfintechresponsi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)



        val pencet = findViewById<Button>(R.id.btlogin)
        pencet.setOnClickListener {
            val lojin= Intent(this, HomeActivity::class.java)
            startActivity(lojin)
        }
        val lupa = findViewById<TextView>(R.id.tvlupa)
        lupa.setOnClickListener {
            val lojin= Intent(this, RecoveryActivity::class.java)
            startActivity(lojin)
        }
        val regis = findViewById<TextView>(R.id.tvregis)
        regis.setOnClickListener {
            val lojin= Intent(this, RegisterActivity::class.java)
            startActivity(lojin)
        }

    }
}