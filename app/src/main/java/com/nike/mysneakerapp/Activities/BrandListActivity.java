package com.nike.mysneakerapp.Activities;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.nike.mysneakerapp.Adapters.BrandAdapter;
import com.nike.mysneakerapp.DataProvider.DataProvider;
import com.nike.mysneakerapp.R;
import com.nike.mysneakerapp.models.Brand;

import java.util.List;

import static com.nike.mysneakerapp.Activities.DisplayBrandActivity.INT_ARRAY_KEY;

public class BrandListActivity extends AppCompatActivity {
    public static final String BRAND_KEY = "com.nike.mysneakerapp.brand_key";
    private List<Brand> brandList = DataProvider.brandList;

    private BrandAdapter brandAdapter;
    private FloatingActionButton fabAddBrand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brand_list);

        fabAddBrand = findViewById(R.id.fabAddBrand);

        brandAdapter = new BrandAdapter(this, brandList);

        ListView brandList = findViewById(R.id.lvBrandList);
        brandList.setAdapter(brandAdapter);

        brandList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(BrandListActivity.this, DisplayBrandActivity.class);
                intent.putExtra(BRAND_KEY, brandAdapter.getItem(position).getBrandID());

                startActivity(intent);
            }
        });

        fabAddBrand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BrandListActivity.this, AddObjectActivity.class);
                int[] extras = { 1, -1};
                intent.putExtra(INT_ARRAY_KEY, extras);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        brandAdapter.notifyDataSetChanged();
    }
}
