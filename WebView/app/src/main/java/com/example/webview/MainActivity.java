package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    Button flipkart, amazon, ebay;
    ImageView ivFlipkart, ivAmazon, ivEbay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flipkart = findViewById(R.id.flipkart);
        amazon = findViewById(R.id.amazon);
        ebay = findViewById(R.id.ebay);

        flipkart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FlipkartActivity.class);
                startActivity(intent);
            }
        });

        amazon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AmazonActivity.class);
                startActivity(intent);
            }
        });

        ebay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EbayActivity.class);
                startActivity(intent);
            }
        });

        ivFlipkart = findViewById(R.id.ivFlipkart);
        ivAmazon = findViewById(R.id.ivAmazon);
        ivEbay = findViewById(R.id.ivEbay);


        ivFlipkart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FlipkartActivity.class);
                startActivity(intent);
            }
        });

        ivAmazon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AmazonActivity.class);
                startActivity(intent);
            }
        });

        ivEbay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EbayActivity.class);
                startActivity(intent);
            }
        });
    }

}