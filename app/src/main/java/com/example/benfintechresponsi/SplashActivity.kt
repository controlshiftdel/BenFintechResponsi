package com.example.benfintechresponsi

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {
    private var PRIVATE_MODE = 0
    private val PREF_NAME = "responsi"
    var sharedPref : SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({

            sharedPref = this.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
            val hasLoggedIn = sharedPref?.getBoolean("hasLoggedIn", false)

            if(hasLoggedIn == true){
                startActivity(Intent(this, HomeActivity::class.java))
                finish()
            }else{
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        }, 3000)
    }
}










