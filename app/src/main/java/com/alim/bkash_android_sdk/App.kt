package com.alim.bkash_android_sdk

import android.app.Application
import com.alim.bkash_sdk.BkashAPI
import com.alim.bkash_sdk.data.model.ModelCredentials

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        BkashAPI.init(
            ModelCredentials(
                baseUrl = "https://tokenized.sandbox.bka.sh",
                username = "user_name",
                password = "password",
                appKey = "app_key",
                appSecret = "app_secret"
            )
        )
    }
}