package com.nike.mysneakerapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nike.mysneakerapp.R;
import com.nike.mysneakerapp.models.Shoe;

import java.util.List;

public class ShoeAdapter extends ArrayAdapter<Shoe> {

    private List<Shoe> mShoe;
    private LayoutInflater mInflater;

    private Shoe currentShoe;

    public ShoeAdapter(Context context, List<Shoe> objects) {
        super(context, R.layout.shoe_list_layout, objects);

        mShoe = objects;
        mInflater = LayoutInflater.from(context);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.shoe_list_layout, parent, false);
        }

        TextView tvName = convertView.findViewById(R.id.tvShoeNameList);
        TextView tvRD = convertView.findViewById(R.id.tvRDList);
        ImageView image = convertView.findViewById(R.id.ivList);

        currentShoe = mShoe.get(position);

        tvName.setText(currentShoe.getName());
        tvRD.setText(currentShoe.getReleaseDate());

        if(currentShoe.getShoeImgUri() != null) {
            image.setImageURI(currentShoe.getShoeImgUri());
        } else {
            image.setImageResource(currentShoe.getImageID());
        }

        return convertView;
    }

}
