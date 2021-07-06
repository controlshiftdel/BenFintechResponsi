package com.example.benfintechresponsi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        etemail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if(android.util.Patterns.EMAIL_ADDRESS.matcher(etemail.text.toString()).matches())

                    else{
                        etemail.setError("Email Salah")
                    }
            }
        })



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