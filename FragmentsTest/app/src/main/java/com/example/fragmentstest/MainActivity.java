package com.example.fragmentstest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListFrag.ItemSelected {

//    private ListFrag listFrag;
    private DetailFrag detailFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        listFrag = new ListFrag();
        detailFrag = new DetailFrag();

        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.listFrag, listFrag)
                .replace(R.id.detailFrag, detailFrag)
                .commit();

    }

    @Override
    public void onItemSelectedABC(int index) {
        detailFrag.updateDescription(index);
    }
}