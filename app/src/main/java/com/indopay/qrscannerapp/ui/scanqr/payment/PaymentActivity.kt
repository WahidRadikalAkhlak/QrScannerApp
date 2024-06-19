package com.indopay.qrscannerapp.ui.scanqr.payment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.indopay.qrscannerapp.R
import com.indopay.qrscannerapp.databinding.ActivityMainBinding
import com.indopay.qrscannerapp.databinding.ActivityPaymentBinding

class PaymentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPaymentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val amount = intent.getStringExtra(EXTRA_AMOUNT) ?: ""
        val tvAmount = findViewById<TextView>(R.id.tvAmount)
        tvAmount.text = amount

        val btnConfirm = findViewById<Button>(R.id.btnConfirm)
        btnConfirm.setOnClickListener {
            val amount = intent.getStringExtra(EXTRA_AMOUNT) ?: ""
            startActivity(PaymentSuccessActivity.newIntent(this@PaymentActivity, amount))
        }
    }

    companion object {
        private const val EXTRA_AMOUNT = "extra_amount"

        fun newIntent(context: Context, amount: String): Intent {
            val intent = Intent(context, PaymentActivity::class.java)
            intent.putExtra(EXTRA_AMOUNT, amount)
            return intent
        }
    }
}