package com.example.benfintechresponsi

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private var PRIVATE_MODE = 0
    private val PREF_NAME = "responsi"
    var sharedPref : SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var helper = MyDBHelper(applicationContext)
        var db = helper.readableDatabase
        btlogin.setOnClickListener {
            sharedPref = this.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
            val editor = sharedPref!!.edit()
            fun make(){
                editor.putBoolean("hasLoggedIn", true)
                editor.commit()
            }


            var args = listOf<String>(etemail.text.toString(), etpassword.text.toString()).toTypedArray()
            var rs = db.rawQuery("SELECT * FROM USERS WHERE UNAME = ? AND PWD = ?", args)
            if(rs.moveToNext()){
                masuk()
                make()}
            else{
                Toast.makeText(applicationContext, "Data User Tidak Terdaftar", Toast.LENGTH_SHORT).show()
            }
        }



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
    fun masuk(){
            val lojin= Intent(this, HomeActivity::class.java)
            startActivity(lojin)
    }


}