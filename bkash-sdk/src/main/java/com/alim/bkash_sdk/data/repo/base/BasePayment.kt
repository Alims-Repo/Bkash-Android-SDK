package com.alim.bkash_sdk.data.repo.base

import com.alim.bkash_sdk.data.model.request.CreatePaymentRequest
import com.alim.bkash_sdk.data.model.request.ExecutePaymentRequest
import com.alim.bkash_sdk.data.model.request.GrantTokenRequest
import com.alim.bkash_sdk.data.model.response.CreatePaymentResponse
import com.alim.bkash_sdk.data.model.response.ExecutePaymentResponse
import com.alim.bkash_sdk.data.model.response.GrantTokenResponse

interface BasePayment {

    suspend fun grantToken() : GrantTokenResponse

    suspend fun paymentCreate(
        grantTokenResponse: GrantTokenResponse,
        createPaymentRequest: CreatePaymentRequest
    ): CreatePaymentResponse

    suspend fun paymentExecute(
        grantTokenResponse: GrantTokenResponse,
        executePaymentRequest: ExecutePaymentRequest
    ): ExecutePaymentResponse
}