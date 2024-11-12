package com.alim.bkash_sdk.data.model.request

import com.google.gson.annotations.SerializedName

data class ExecutePaymentRequest(
    @SerializedName("paymentID")
    var paymentID: String? = null,
)