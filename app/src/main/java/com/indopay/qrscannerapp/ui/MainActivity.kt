package com.indopay.qrscannerapp.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.indopay.qrscannerapp.R
import com.indopay.qrscannerapp.databinding.ActivityMainBinding
import com.indopay.qrscannerapp.ui.scanqr.ScanQrActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        val scanNowButton: Button = findViewById(R.id.scannow)

        scanNowButton.setOnClickListener {
            val intent = Intent(this, ScanQrActivity::class.java)
            startActivity(intent)
        }
    }
}