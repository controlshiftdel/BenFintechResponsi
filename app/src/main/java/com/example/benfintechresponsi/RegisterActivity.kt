package com.example.benfintechresponsi

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_recovery.*
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_register.etemail
import kotlinx.android.synthetic.main.activity_register.etpassword

class RegisterActivity : AppCompatActivity() {
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
                if(confirmpass.length() > 0 && etpassword.length() > 0){
                    if(!confirmpass.equals(etpassword)) {
                        confirmpass.error = "Password Tidak Cocok"
                        }


                }
            }
        })

        btregister.setOnClickListener{
            var cv = ContentValues()
            cv.put("UNAME", etemail.text.toString())
            cv.put("PWD", etpassword.text.toString())
            db.insert("USERS", null, cv)

            etemail.setText("")
            etpassword.setText("")
            confirmpass.setText("")


                val lojin = Intent(this, HomeActivity::class.java)
                startActivity(lojin)
                Toast.makeText(this, "Data Sudah Teregister, Selamat datang", Toast.LENGTH_LONG).show()

            }


        }
    }

















