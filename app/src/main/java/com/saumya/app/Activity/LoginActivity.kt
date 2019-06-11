package com.saumya.app.Activity

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import com.saumya.app.R
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {

    private var mywebview: WebView? = null
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnnext.setOnClickListener {
            Toast.makeText(baseContext,"Logged In", Toast.LENGTH_SHORT).show()
            startActivity(Intent(baseContext, OpenLook::class.java))
        }
//        mywebview = findViewById<WebView>(R.id.web)
//
//        mywebview!!.settings.javaScriptEnabled = true
//        mywebview!!.settings.cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK
//
//        mywebview!!.settings.cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK
//        mywebview!!.webViewClient = object : WebViewClient() {
//            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
//                view?.loadUrl(url)
//                return true
//            }
//        }
//
//        mywebview!!.loadUrl("http://m-biz.in/")
        tvsignup.setOnClickListener {

            startActivity(Intent(baseContext, SignUpActivity::class.java))
        }

    }
}
