package com.alim.bkash_sdk.data.model.response

import com.google.gson.annotations.SerializedName


data class GrantTokenResponse (
    @SerializedName("statusCode")
    var statusCode : String? = null,
    @SerializedName("statusMessage")
    var statusMessage : String? = null,
    @SerializedName("id_token")
    var idToken : String? = null,
    @SerializedName("token_type")
    var tokenType : String? = null,
    @SerializedName("expires_in")
    var expiresIn : Int? = null,
    @SerializedName("refresh_token")
    var refreshToken : String? = null
)