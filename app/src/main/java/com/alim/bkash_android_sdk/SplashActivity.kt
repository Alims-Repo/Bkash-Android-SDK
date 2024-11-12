package com.alim.bkash_android_sdk

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.alim.bkash_sdk.BkashAPI
import com.alim.bkash_sdk.data.model.request.CreatePaymentRequest
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        CoroutineScope(Dispatchers.IO).launch {
            BkashAPI.makePayment(
                this@SplashActivity,
                CreatePaymentRequest(
                    mode = "0011",
                    amount = "100",
                    intent = "sale",
                    currency = "BDT",
                    payerReference = "online",
                    callbackURL = "https://www.test.com",
                    merchantInvoiceNumber = "123456",
                )
            )
        }
    }
}