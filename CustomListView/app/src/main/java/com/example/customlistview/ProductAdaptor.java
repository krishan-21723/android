package com.example.customlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ProductAdaptor extends ArrayAdapter<Product> {

    private final Context context;
    private final List<Product> values;


    public ProductAdaptor(Context context, List<Product> list) {
        super(context, R.layout.row_layout, list);
        this.context = context;
        this.values = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row_layout, parent, false);

        TextView tvProduct = (TextView) rowView.findViewById(R.id.tvProduct);
        TextView tvPrice = (TextView) rowView.findViewById(R.id.tvPrice);
        TextView tvDescription = (TextView) rowView.findViewById(R.id.tvDescription);
        ImageView ivProduct = (ImageView) rowView.findViewById(R.id.ivProduct);
        ImageView ivSale = (ImageView) rowView.findViewById(R.id.ivSale);

        tvProduct.setText(values.get(position).getTitle());
        tvPrice.setText(values.get(position).getPrice() + "");
        tvDescription.setText(values.get(position).getDescription());

        if (values.get(position).isSale()) {
            ivSale.setImageResource(R.mipmap.sale);
        } else {
            ivSale.setImageResource(R.mipmap.best_price);
        }

        if (values.get(position).getType().equals("Laptop")) {
            ivProduct.setImageResource(R.mipmap.laptop_foreground);
        } else if (values.get(position).getType().equals("Memory")) {
            ivProduct.setImageResource(R.mipmap.memory_foreground);
        } else if (values.get(position).getType().equals("Screen")) {
            ivProduct.setImageResource(R.mipmap.screen_foreground);
        } else {
            ivProduct.setImageResource(R.mipmap.hdd_foreground);
        }

        return rowView;
    }
}
