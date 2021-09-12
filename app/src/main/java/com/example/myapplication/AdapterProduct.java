package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterProduct extends BaseAdapter {
    List<Product> products;

    public AdapterProduct(List<Product> products) {
        this.products = products;
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int position) {
        return products.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view1 = layoutInflater.inflate(R.layout.item_product,viewGroup,false);

        TextView tvname = view1.findViewById(R.id.tvname);
        TextView phone = view1.findViewById(R.id.tvphone);
        ImageView img = view1.findViewById(R.id.imag);

        Product product = products.get(position);

        tvname.setText(product.getName());
        phone.setText(product.getNumberphone());
        if (product.isAvatarUser()) img.setVisibility(View.VISIBLE);
        else img.setVisibility(View.GONE);

        return view1;
    }
}
