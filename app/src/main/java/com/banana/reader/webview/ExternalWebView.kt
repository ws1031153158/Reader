package com.banana.reader.webview

import android.os.Bundle
import android.webkit.WebViewClient
import com.banana.reader.BaseActivity
import com.banana.reader.databinding.WebviewActivityBinding

class ExternalWebView : BaseActivity() {

    private lateinit var mBinding : WebviewActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = WebviewActivityBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.webView.webViewClient = WebViewClient()
        with(mBinding.webView.settings) {
            javaScriptEnabled = true
            domStorageEnabled = true
            builtInZoomControls = true
            setGeolocationEnabled(true)

        }
    }
}