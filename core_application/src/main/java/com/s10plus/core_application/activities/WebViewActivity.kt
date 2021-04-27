package com.s10plus.core_application.activities

import android.os.Bundle
import android.view.View
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.s10plus.core_application.R
import com.s10plus.core_application.base_ui.BaseActivity
import com.s10plus.core_application.base_ui.BaseFragment
import com.s10plus.core_application.databinding.ActivityWebviewBinding
import com.s10plus.core_application.ui.dialog.TypeDialog

class WebViewActivity: BaseActivity<ActivityWebviewBinding>(R.layout.activity_webview) {

    lateinit var url:String

    override fun setupView() {
        url = intent?.getStringExtra(URL)?:""

        binding.webview.settings.javaScriptEnabled = true


        showLoader()
        binding.webview.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                view.loadUrl(url)
                return true
            }

            override fun onLoadResource(view: WebView, url: String) {
            }

            override fun onPageFinished(view: WebView, url: String) {
                hideLoader()

            }

            override fun onReceivedError(
                view: WebView?,
                request: WebResourceRequest?,
                error: WebResourceError?
            ) {
                super.onReceivedError(view, request, error)
                binding.webview.visibility = View.GONE
                showDialog(
                    TypeDialog.ERROR,
                    "Error de conexión",
                    "Conectate a una red para cargar esta sección",
                    cancel = null,ok = {
                        onBackPressed()
                        it.dismiss()
                    }
                )
            }
        }
        binding.webview.loadUrl(url)    }

    override fun setupObserver() {
    }

    override fun setupViewModel() {
    }

    override fun init() {
    }
    companion object{
        const val URL ="URL"


    }
}