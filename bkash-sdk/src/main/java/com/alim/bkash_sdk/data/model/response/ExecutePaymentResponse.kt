package com.alim.bkash_sdk.data.model.response

import com.google.gson.annotations.SerializedName

data class ExecutePaymentResponse (
    @SerializedName("statusCode")
    var statusCode : String? = null,
    @SerializedName("statusMessage")
    var statusMessage : String? = null,
    @SerializedName("paymentID")
    var paymentID : String? = null,
    @SerializedName("payerReference")
    var payerReference : String? = null,
    @SerializedName("customerMsisdn")
    var customerMsisdn : String? = null,
    @SerializedName("trxID")
    var trxID : String? = null,
    @SerializedName("amount")
    var amount : String? = null,
    @SerializedName("transactionStatus")
    var transactionStatus : String? = null,
    @SerializedName("paymentExecuteTime")
    var paymentExecuteTime : String? = null,
    @SerializedName("currency")
    var currency : String? = null,
    @SerializedName("intent")
    var intent : String? = null,
    @SerializedName("merchantInvoiceNumber")
    var merchantInvoiceNumber : String? = null
)