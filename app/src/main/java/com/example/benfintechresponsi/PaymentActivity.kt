package com.example.benfintechresponsi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_payment.*
import kotlinx.android.synthetic.main.activity_profile.*

class PaymentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        btpay.setOnClickListener{
            validatepay()
            val lojin= Intent(this, HomeActivity::class.java)
            startActivity(lojin)
        }
    }
    fun validatepay() : Boolean{
        if(etpay.text.length == 0){
            Toast.makeText(this, "Harap Mengisi kode ", Toast.LENGTH_LONG).show()
            return false
        } else {

            return true
        }
    }
}