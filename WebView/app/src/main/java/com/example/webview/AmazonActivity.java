package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class AmazonActivity extends AppCompatActivity {

    WebView wvAmazon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amazon);

        wvAmazon = findViewById(R.id.wvAmazon);

        wvAmazon.setWebViewClient(new WebViewClient());
        wvAmazon.getSettings().setJavaScriptEnabled(true);
        wvAmazon.loadUrl("https://www.amazon.com");
    }

    @Override
    public void onBackPressed() {
        if (wvAmazon.canGoBack()) {
            wvAmazon.goBack();
        } else {
            super.onBackPressed();
        }
    }
}