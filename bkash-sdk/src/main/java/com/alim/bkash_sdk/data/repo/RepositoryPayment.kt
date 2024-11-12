package com.alim.bkash_sdk.data.repo

import com.alim.bkash_sdk.data.model.ModelCredentials
import com.alim.bkash_sdk.data.model.request.CreatePaymentRequest
import com.alim.bkash_sdk.data.model.request.ExecutePaymentRequest
import com.alim.bkash_sdk.data.model.request.GrantTokenRequest
import com.alim.bkash_sdk.data.model.response.CreatePaymentResponse
import com.alim.bkash_sdk.data.model.response.ExecutePaymentResponse
import com.alim.bkash_sdk.data.model.response.GrantTokenResponse
import com.alim.bkash_sdk.data.repo.base.BasePayment
import com.alim.bkash_sdk.remote.ApiClient

class RepositoryPayment(
    private val modelCredentials: ModelCredentials
) : BasePayment {

    private val bkashApi = ApiClient.getApi(modelCredentials.baseUrl)

    override suspend fun grantToken(): GrantTokenResponse {
        return bkashApi.postGrantToken(
            username = modelCredentials.username,
            password = modelCredentials.password,
            grantTokenRequest = GrantTokenRequest(
                appKey = modelCredentials.appKey,
                appSecret = modelCredentials.appSecret
            )
        )
    }

    override suspend fun paymentCreate(
        grantTokenResponse: GrantTokenResponse,
        createPaymentRequest: CreatePaymentRequest
    ): CreatePaymentResponse {
        return bkashApi.postPaymentCreate(
            authorization = "Bearer " + grantTokenResponse.idToken,
            xAppKey = modelCredentials.appKey,
            createPaymentRequest = createPaymentRequest
        )
    }

    override suspend fun paymentExecute(
        grantTokenResponse: GrantTokenResponse,
        executePaymentRequest: ExecutePaymentRequest
    ): ExecutePaymentResponse {
        return bkashApi.postPaymentExecute(
            authorization = "Bearer " + grantTokenResponse.idToken,
            xAppKey = modelCredentials.appKey,
            executePaymentRequest = ExecutePaymentRequest(
                paymentID = executePaymentRequest.paymentID
            )
        )
    }
}