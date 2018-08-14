package com.example.roman.news

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.web_detail_news.*
import android.webkit.WebView
import android.webkit.WebViewClient



class WebDetailView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.web_detail_news)
        web_view.settings.javaScriptEnabled = true
        val intent = getIntent()
        web_view.loadUrl(intent.getStringExtra("key"))
        web_view.webViewClient = MyWebViewClient()
    }

    private inner class MyWebViewClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            view.loadUrl(url)
            return true
        }

    }

    override fun onBackPressed() {
        if (web_view.canGoBack()) {
            web_view.goBack()
        } else {
            super.onBackPressed()
        }
    }
}