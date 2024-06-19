package com.indopay.qrscannerapp.ui.scanqr.payment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.indopay.qrscannerapp.R
import com.indopay.qrscannerapp.databinding.ActivityPaymentBinding
import com.indopay.qrscannerapp.databinding.ActivityPaymentSuccessBinding
import com.indopay.qrscannerapp.ui.MainActivity

class PaymentSuccessActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPaymentSuccessBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentSuccessBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val amount = intent.getStringExtra(EXTRA_AMOUNT) ?: ""
        val tvAmount = findViewById<TextView>(R.id.tvAmount)
        tvAmount.text = amount

    }

    companion object {
        private const val EXTRA_AMOUNT = "extra_amount"

        fun newIntent(context: Context, amount: String): Intent {
            val intent = Intent(context, PaymentSuccessActivity::class.java)
            intent.putExtra(EXTRA_AMOUNT, amount)
            return intent
        }
    }

    fun goHome(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}