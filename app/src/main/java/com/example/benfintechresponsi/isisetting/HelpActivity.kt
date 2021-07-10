package com.example.benfintechresponsi.isisetting

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.benfintechresponsi.HomeActivity
import com.example.benfintechresponsi.R
import com.example.benfintechresponsi.SplashActivity
import kotlinx.android.synthetic.main.activity_help.*

class HelpActivity : AppCompatActivity() {
    private var PRIVATE_MODE = 0
    private val PREF_NAME = "responsi"
    var sharedPref : SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help)

        btlogout.setOnClickListener {
            sharedPref = this.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
            val editor = sharedPref!!.edit()
            editor.putBoolean("hasLoggedIn", false)
            editor.commit()

            val lojin= Intent(this, SplashActivity::class.java)
            startActivity(lojin)

            finish()
        }


    }
}