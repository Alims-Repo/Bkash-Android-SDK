package com.alim.bkash_sdk.data.model.request

import com.google.gson.annotations.SerializedName

data class CreatePaymentRequest(
    @SerializedName("mode")
    var mode: String? = null,
    @SerializedName("payerReference")
    var payerReference: String? = null,
    @SerializedName("callbackURL")
    var callbackURL: String? = null,
    @SerializedName("merchantAssociationInfo")
    var merchantAssociationInfo: String? = null,
    @SerializedName("amount")
    var amount: String? = null,
    @SerializedName("currency")
    var currency: String? = null,
    @SerializedName("intent")
    var intent: String? = null,
    @SerializedName("merchantInvoiceNumber")
    var merchantInvoiceNumber: String? = null,
)