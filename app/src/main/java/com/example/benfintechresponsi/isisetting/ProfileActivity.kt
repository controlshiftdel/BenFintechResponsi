package com.example.benfintechresponsi.isisetting

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.benfintechresponsi.HomeActivity
import com.example.benfintechresponsi.R
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_register.etemail

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        btsave.setOnClickListener {
            validall()

        }

    }
    private fun validall(){
        if(validateEmail() && validateAddres() && validateName()){
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Telah Tervalidasi ", Toast.LENGTH_LONG).show()
        }
    }

    fun validateEmail() : Boolean{
        if(etemails.text.length == 0){
            Toast.makeText(this, "Harap Mengisi Email ", Toast.LENGTH_LONG).show()
            return false
        } else if(!Patterns.EMAIL_ADDRESS.matcher(etemails.text).matches()){
            Toast.makeText(this, "Format Email salah ", Toast.LENGTH_LONG).show()
            return false
        } else {

            return true
        }
    }
    fun validateName() : Boolean{
        if(etnama.text.length == 0){
            Toast.makeText(this, "Harap Mengisi nama ", Toast.LENGTH_LONG).show()
            return false
        } else {

            return true
        }
    }
    fun validateAddres() : Boolean{
        if(etalamat.text.length == 0){
            Toast.makeText(this, "Harap Mengisi alamat ", Toast.LENGTH_LONG).show()
            return false
        } else {

            return true
        }
    }
}