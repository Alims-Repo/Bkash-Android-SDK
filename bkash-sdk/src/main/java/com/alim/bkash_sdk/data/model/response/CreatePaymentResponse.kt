package com.alim.bkash_sdk.data.model.response

import com.google.gson.annotations.SerializedName

data class CreatePaymentResponse (
    @SerializedName("statusCode")
    var statusCode : String? = null,
    @SerializedName("statusMessage")
    var statusMessage : String? = null,
    @SerializedName("paymentID")
    var paymentID : String? = null,
    @SerializedName("bkashURL")
    var bkashURL : String? = null,
    @SerializedName("callbackURL")
    var callbackURL : String? = null,
    @SerializedName("successCallbackURL")
    var successCallbackURL : String? = null,
    @SerializedName("failureCallbackURL")
    var failureCallbackURL : String? = null,
    @SerializedName("cancelledCallbackURL")
    var cancelledCallbackURL : String? = null,
    @SerializedName("amount")
    var amount : String? = null,
    @SerializedName("intent")
    var intent : String? = null,
    @SerializedName("currency")
    var currency : String? = null,
    @SerializedName("paymentCreateTime")
    var paymentCreateTime : String? = null,
    @SerializedName("transactionStatus")
    var transactionStatus : String? = null,
    @SerializedName("merchantInvoiceNumber")
    var merchantInvoiceNumber : String? = null,
    @SerializedName("message")
    var message : String? = null
)