package com.alim.bkash_sdk

import android.app.Activity
import android.util.Log
import com.alim.bkash_sdk.data.model.ModelCredentials
import com.alim.bkash_sdk.data.model.request.CreatePaymentRequest
import com.alim.bkash_sdk.data.model.request.ExecutePaymentRequest
import com.alim.bkash_sdk.data.model.response.ExecutePaymentResponse
import com.alim.bkash_sdk.data.repo.RepositoryPayment
import com.alim.bkash_sdk.data.repo.base.BasePayment
import kotlin.jvm.Throws

object BkashAPI : BaseBkash() {

    private lateinit var repositoryPayment: BasePayment

    override suspend fun makePayment(
        activity: Activity,
        request: CreatePaymentRequest
    ): ExecutePaymentResponse? {
        if (this::repositoryPayment.isInitialized.not())
            throw Exception("BkashAPI not initialized. Call init() first.")
        val token = repositoryPayment.grantToken()
        Log.e("Token", token.toString())
        val createPaymentResponse = repositoryPayment.paymentCreate(token, request)
        Log.e("CreatePaymentResponse", createPaymentResponse.toString())
        showWebView(activity, createPaymentResponse.bkashURL.toString())
        val ex = ExecutePaymentRequest(createPaymentResponse.paymentID)
        val executePaymentResponse = repositoryPayment.paymentExecute(token, ex)
        Log.e("ExecutePaymentResponse", executePaymentResponse.toString())
        return null
    }

    fun init(credentials: ModelCredentials) {
        repositoryPayment = RepositoryPayment(credentials)
    }
}