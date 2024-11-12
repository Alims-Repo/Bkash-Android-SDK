package com.alim.bkash_sdk

import android.app.Activity
import com.alim.bkash_sdk.data.model.request.CreatePaymentRequest
import com.alim.bkash_sdk.data.model.response.ExecutePaymentResponse
import com.alim.bkash_sdk.ui.WebViewBottomSheetDialog
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class BaseBkash {

    abstract suspend fun makePayment(activity: Activity, request: CreatePaymentRequest): ExecutePaymentResponse?

    protected suspend fun showWebView(activity: Activity, url: String) {
        withContext(Dispatchers.Main) {
            if (activity.isDestroyed)
                throw Exception("Activity is destroyed.")

            WebViewBottomSheetDialog(activity).startFlow(url)
        }
    }
}