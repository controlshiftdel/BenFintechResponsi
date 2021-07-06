package com.example.benfintechresponsi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.benfintechresponsi.fragments.HistoryFragment
import com.example.benfintechresponsi.fragments.HomeFragment
import com.example.benfintechresponsi.fragments.PaymentFragment
import com.example.benfintechresponsi.fragments.SettingFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        val homeFragment = HomeFragment()
        val historyFragment = HistoryFragment()
        val paymentFragment = PaymentFragment()
        val settingFragment = SettingFragment()

        makeCurrentFragment(homeFragment)

        findViewById<BottomNavigationView>(R.id.bottom_navigation).setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.navhome -> makeCurrentFragment(homeFragment)
                R.id.navpay -> makeCurrentFragment(paymentFragment)
                R.id.navhistory -> makeCurrentFragment(historyFragment)
                R.id.navsetting -> makeCurrentFragment(settingFragment)
            }
            true
        }


    }

    private fun makeCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentcontainer, fragment)
            commit()
    }
}