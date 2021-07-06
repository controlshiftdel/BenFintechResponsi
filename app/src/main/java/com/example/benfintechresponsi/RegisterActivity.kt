package com.example.benfintechresponsi

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        var helper = MyDBHelper(applicationContext)
        var db = helper.readableDatabase
        var rs = db.rawQuery("SELECT * FROM USERS", null)

        if (rs.moveToNext())
            Toast.makeText(applicationContext, rs.getString(1), Toast.LENGTH_LONG).show()

        btregister.setOnClickListener{
            var cv = ContentValues()
            cv.put("UNAME", etemail.text.toString())
            cv.put("PWD", etpassword.text.toString())
            db.insert("USERS", null, cv)

            etemail.setText("")
            etpassword.setText("")
            etemail.requestFocus()

            val lojin= Intent(this, HomeActivity::class.java)
            startActivity(lojin)
            Toast.makeText(this, "Data Sudah Teregister, Selamat datang", Toast.LENGTH_LONG).show()

        }


        }
    }

















