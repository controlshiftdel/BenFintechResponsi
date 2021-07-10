package com.example.benfintechresponsi.fragments

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.budiyev.android.codescanner.AutoFocusMode
import com.budiyev.android.codescanner.CodeScanner
import com.budiyev.android.codescanner.CodeScannerView
import com.budiyev.android.codescanner.DecodeCallback
import com.budiyev.android.codescanner.ScanMode
import com.example.benfintechresponsi.HomeActivity
import com.example.benfintechresponsi.PaymentActivity
import com.example.benfintechresponsi.R
import com.example.benfintechresponsi.RecoveryActivity
import kotlinx.android.synthetic.main.fragment_payment.*
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class PaymentFragment : Fragment() {

    private lateinit var  codescanner : CodeScanner

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvkode.setOnClickListener{
            activity?.let{
                val intent = Intent (it, PaymentActivity::class.java)
                startActivity(intent)
            }
        }
        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.CAMERA)==
            PackageManager.PERMISSION_DENIED){
            ActivityCompat.requestPermissions(requireActivity(), arrayOf(Manifest.permission.CAMERA), 123)
        }else{
            startScanning()
        }

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_payment, container, false)



    }

    private fun startScanning() {
        val scannerView: CodeScannerView = scanner_view
        codescanner = CodeScanner(requireContext(), scannerView)
        codescanner.camera = CodeScanner.CAMERA_BACK
        codescanner.formats = CodeScanner.ALL_FORMATS

        codescanner.autoFocusMode = AutoFocusMode.SAFE
        codescanner.scanMode = ScanMode.SINGLE
        codescanner.isAutoFocusEnabled = true
        codescanner.isFlashEnabled = false
        codescanner.decodeCallback = DecodeCallback {

        }

        scanner_view.setOnClickListener {
            codescanner.startPreview()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>,grantResults: IntArray){
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 123){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(requireContext(), "Camera granted", Toast.LENGTH_SHORT).show()
                startScanning()
            }else{
                Toast.makeText(requireContext(), "Camera denied", Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun onResume() {
        super.onResume()
        if (::codescanner.isInitialized){
            codescanner?.startPreview()
        }
    }

    override fun onPause() {
        if (::codescanner.isInitialized){
            codescanner?.releaseResources()
        }
        super.onPause()
    }

}





















