package com.nike.mysneakerapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nike.mysneakerapp.CompoundControls.NumberOfShoesBarView;
import com.nike.mysneakerapp.R;
import com.nike.mysneakerapp.models.Brand;
import com.nike.mysneakerapp.models.Shoe;

import java.util.List;

public class BrandAdapter extends ArrayAdapter<Brand> {
    private List<Brand> mBrand;
    private LayoutInflater mInflater;

    private NumberOfShoesBarView numberOfShoesBarView;
    private TextView tvBrandName;
    private TextView tvBrandEstDate;
//    private TextView tvBrandNumberOfShoes;
    private ImageView ivBrandLogo;
    private Brand currentBrand;

    public BrandAdapter(Context context, List<Brand> objects) {
        super(context, R.layout.brand_list_layout, objects);

        mBrand = objects;
        mInflater = LayoutInflater.from(context);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.brand_list_layout, parent, false);
        }

        tvBrandName = convertView.findViewById(R.id.tvBrandNameBrandList);
        tvBrandEstDate = convertView.findViewById(R.id.tvEstDateBrandList);
//        tvBrandNumberOfShoes = convertView.findViewById(R.id.tvNumbOfShoesBrandList);
        ivBrandLogo = convertView.findViewById(R.id.ivBrandLogoBrandList);
        numberOfShoesBarView = convertView.findViewById(R.id.numberOfShoesBarView);

        currentBrand = mBrand.get(position);
        numberOfShoesBarView.setNumberOfShoes(currentBrand.getNumberOfShoesInt());

        tvBrandName.setText(currentBrand.getName());
        tvBrandEstDate.setText(currentBrand.getEstablishmentDate());
//        tvBrandNumberOfShoes.setText(currentBrand.getNumberOfShoesString());

        if(currentBrand.getImageUri() != null) {
            ivBrandLogo.setImageURI(currentBrand.getImageUri());
        } else {
            ivBrandLogo.setImageResource(currentBrand.getImageID());
        }

        return convertView;
    }
}
