package com.example.benfintechresponsi

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.basgeekball.awesomevalidation.AwesomeValidation
import com.basgeekball.awesomevalidation.ValidationStyle
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_recovery.*
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_register.etemail
import kotlinx.android.synthetic.main.activity_register.etpassword

class RegisterActivity : AppCompatActivity() {

    val valid = AwesomeValidation(ValidationStyle.BASIC)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        var helper = MyDBHelper(applicationContext)
        var db = helper.readableDatabase
        var rs = db.rawQuery("SELECT * FROM USERS", null)



        etemail.addTextChangedListener(object:TextWatcher  {
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
        confirmpass.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {

            }
        })

        valid.addValidation(this, R.id.confirmpass, R.id.etpassword, R.string.erorr )

        btcek.setOnClickListener {
            if(valid.validate()){
                Toast.makeText(this, "data kelar", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Not complete", Toast.LENGTH_SHORT).show()
            }
        }


        btregister.setOnClickListener{
            var cv = ContentValues()
            cv.put("UNAME", etemail.text.toString())
            cv.put("PWD", etpassword.text.toString())
            db.insert("USERS", null, cv)

            etemail.setText("")
            etpassword.setText("")
            confirmpass.setText("")

            Toast.makeText(this, "Data Sudah Teregister, Selamat datang", Toast.LENGTH_SHORT).show()
            val lojin = Intent(this, HomeActivity::class.java)
            startActivity(lojin)

            }


        }
    }

















