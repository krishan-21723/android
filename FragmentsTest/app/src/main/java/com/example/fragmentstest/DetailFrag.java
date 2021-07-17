package com.example.fragmentstest;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class DetailFrag extends Fragment {
    private TextView tvDescription;

    String[] descriptions;

    public DetailFrag() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        descriptions = getResources().getStringArray(R.array.descriptions);

        View v = inflater.inflate(R.layout.fragment_detail, container, false);

        tvDescription = v.findViewById(R.id.tvDescription);

        return v;
    }

    public void updateDescription(int index) {
        tvDescription.setText(descriptions[index]);
    }
}