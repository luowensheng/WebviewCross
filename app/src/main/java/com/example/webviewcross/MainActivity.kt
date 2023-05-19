package com.example.webviewcross

import android.os.Bundle
import android.view.LayoutInflater
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity

class MainActivity: AppCompatActivity() {
    private lateinit var webView: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        webView = LayoutInflater.from(this).inflate(R.layout.main, null) as WebView
        webView.settings.javaScriptEnabled = true
        val index = application.assets.open("index.html").bufferedReader().use { it.readText() }
        webView.loadHTML(index)
        setContentView(webView)
    }

}

fun WebView.loadHTML(html:String){
    this.loadDataWithBaseURL(null, html, "text/html", "utf-8", null)
}