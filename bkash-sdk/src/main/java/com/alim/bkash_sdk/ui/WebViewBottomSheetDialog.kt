package com.alim.bkash_sdk.ui

import android.app.Activity
import android.content.DialogInterface
import android.graphics.Bitmap
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import com.alim.bkash_sdk.R
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

class WebViewBottomSheetDialog(
    private val activity: Activity
) : BottomSheetDialog(activity, R.style.AppBottomSheetDialogTheme) {

    init {
        setContentView(R.layout.dialog_webview)
        setCancelable(false)
    }

    suspend fun startFlow(url: String): Boolean = suspendCancellableCoroutine { continuation ->
        var resumed = false
        val progressBar = findViewById<ProgressBar>(R.id.loading)!!
        val webView = findViewById<WebView>(R.id.WebView)
        webView?.apply {
            webViewClient = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                    view.loadUrl(url)
                    return true
                }

                override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                    progressBar.visibility = View.VISIBLE
                }

                override fun onPageFinished(view: WebView?, url: String?) {
                    progressBar.visibility = View.GONE
                    if (resumed) {
                        dismiss()
                        return
                    }
                    resumed = true
                    if (url.toString().contains("status=success")) {
                        continuation.resume(true)
                        dismiss()
                    } else {
                        continuation.resume(false)
                        dismiss()
                    }
                }
            }
            webChromeClient = object : WebChromeClient() {
                override fun onProgressChanged(view: WebView?, newProgress: Int) {
                    progressBar?.progress = newProgress
                    if (newProgress == 100) {
                        progressBar.visibility = View.GONE
                    }
                }
            }

            settings.javaScriptEnabled = true
            settings.allowContentAccess = true
            settings.domStorageEnabled = true
            settings.useWideViewPort = true
            loadUrl(url)
        }
        show()
    }

    override fun setOnShowListener(listener: DialogInterface.OnShowListener?) {
        super.setOnShowListener(listener)
        window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT // Adjust to fit content or screen as necessary
        )
    }
}