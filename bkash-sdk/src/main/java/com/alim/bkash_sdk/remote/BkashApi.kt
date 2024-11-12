package com.alim.bkash_sdk.remote

import com.alim.bkash_sdk.data.model.request.CreatePaymentRequest
import com.alim.bkash_sdk.data.model.request.ExecutePaymentRequest
import com.alim.bkash_sdk.data.model.request.GrantTokenRequest
import com.alim.bkash_sdk.data.model.response.CreatePaymentResponse
import com.alim.bkash_sdk.data.model.response.ExecutePaymentResponse
import com.alim.bkash_sdk.data.model.response.GrantTokenResponse
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface BkashApi {

    @POST("/v1.2.0-beta/tokenized/checkout/token/grant")
    suspend fun postGrantToken(
        @Header("username") username: String?,
        @Header("password") password: String?,
        @Body grantTokenRequest: GrantTokenRequest
    ): GrantTokenResponse

    @POST("/v1.2.0-beta/tokenized/checkout/create")
    suspend fun postPaymentCreate(
        @Header("authorization") authorization: String?,
        @Header("x-app-key") xAppKey: String?,
        @Body createPaymentRequest: CreatePaymentRequest
    ): CreatePaymentResponse

    @POST("/v1.2.0-beta/tokenized/checkout/execute")
    suspend fun postPaymentExecute(
        @Header("authorization") authorization: String?,
        @Header("x-app-key") xAppKey: String?,
        @Body executePaymentRequest: ExecutePaymentRequest
    ): ExecutePaymentResponse
}