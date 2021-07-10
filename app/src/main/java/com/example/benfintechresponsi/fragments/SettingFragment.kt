package com.example.benfintechresponsi.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.benfintechresponsi.PaymentActivity
import com.example.benfintechresponsi.R
import com.example.benfintechresponsi.isisetting.BankActivity
import com.example.benfintechresponsi.isisetting.ProfileActivity
import kotlinx.android.synthetic.main.fragment_payment.*
import kotlinx.android.synthetic.main.fragment_setting.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SettingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SettingFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pencet()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_setting, container, false)
    }

    fun pencet(){
        tvprofil.setOnClickListener{
            activity?.let{
                val intent = Intent (it, ProfileActivity::class.java)
                startActivity(intent)
            }
        }
        tvbank.setOnClickListener{
            activity?.let{
                val intent = Intent (it, BankActivity::class.java)
                startActivity(intent)
            }
        }
        tvcredit.setOnClickListener{
            activity?.let{
                val intent = Intent (it, PaymentActivity::class.java)
                startActivity(intent)
            }
        }
        tvpassword.setOnClickListener{
            activity?.let{
                val intent = Intent (it, PaymentActivity::class.java)
                startActivity(intent)
            }
        }
        tvhelp.setOnClickListener{
            activity?.let{
                val intent = Intent (it, PaymentActivity::class.java)
                startActivity(intent)
            }
        }
    }

}