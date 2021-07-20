package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class FlipkartActivity extends AppCompatActivity {

    WebView wvFlipkart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flipkart);

        wvFlipkart = findViewById(R.id.wvFlipkart);

        wvFlipkart.setWebViewClient(new WebViewClient());
        wvFlipkart.getSettings().setJavaScriptEnabled(true);
        wvFlipkart.loadUrl("https://www.flipkart.com");
    }

    @Override
    public void onBackPressed() {
        if (wvFlipkart.canGoBack()) {
            wvFlipkart.goBack();
        } else {
            super.onBackPressed();
        }
    }
}