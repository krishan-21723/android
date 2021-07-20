package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class EbayActivity extends AppCompatActivity {

    WebView wvEbay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ebay);

        wvEbay = findViewById(R.id.wvEbay);

        wvEbay.setWebViewClient(new WebViewClient());
        wvEbay.getSettings().setJavaScriptEnabled(true);
        wvEbay.loadUrl("https://www.ebay.com");
    }

    @Override
    public void onBackPressed() {
        if (wvEbay.canGoBack()) {
            wvEbay.goBack();
        } else {
            super.onBackPressed();
        }
    }
}