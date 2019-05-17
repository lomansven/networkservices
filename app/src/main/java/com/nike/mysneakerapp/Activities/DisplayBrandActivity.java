package com.nike.mysneakerapp.Activities;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.nike.mysneakerapp.DataProvider.DataProvider;
import com.nike.mysneakerapp.R;
import com.nike.mysneakerapp.Adapters.ShoeAdapter;
import com.nike.mysneakerapp.models.Brand;

import static com.nike.mysneakerapp.Activities.BrandListActivity.BRAND_KEY;

public class DisplayBrandActivity extends AppCompatActivity {

    public static final String SHOE_KEY = "com.nike.mysneakerapp.shoe_key";
    public static final String INT_ARRAY_KEY = "com.nike.mysneakerapp.int_array_key";

    private ShoeAdapter shoeAdapter;
    private int currentBrandID = -1;

    private TextView brandName;
    private TextView brandEstDate;
    private TextView brandDetails;
    private ImageView brandLogo;
    private ListView brandShoeList;
    private Button btnDeleteBrand;
    private FloatingActionButton fabAddNewShoe;
    private FloatingActionButton fabEditBrand;

    private Brand currentBrand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_brand);

        brandName = findViewById(R.id.tvBrandNameDBA);
        brandEstDate = findViewById(R.id.tvEstDateBDA);
        brandDetails = findViewById(R.id.tvBrandDetailsBDA);
        brandLogo = findViewById(R.id.ivBrandLogoBDA);
        brandShoeList = findViewById(R.id.lvBrandShoes);
        btnDeleteBrand = findViewById(R.id.btnDeleteBrand);
        fabAddNewShoe = findViewById(R.id.fabAddNewShoe);
        fabEditBrand = findViewById(R.id.fabEditBrand);

        Intent intent = getIntent();

        currentBrandID = intent.getIntExtra(BRAND_KEY, -1);
        if(currentBrandID != -1) {
            currentBrand = DataProvider.getBrandByID(currentBrandID);
        } else {
            Toast.makeText(this, R.string.brand_not_found_error, Toast.LENGTH_SHORT).show();
        }

        setTexts();

        setImage();


        //List with all shoes from displayed brand is given here instead of the DataProvider's shoeList (which has all shoes)
        shoeAdapter = new ShoeAdapter(this, currentBrand.getShoeList());
        brandShoeList.setAdapter(shoeAdapter);

        brandShoeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent1 = new Intent(DisplayBrandActivity.this, DisplayShoeActivity.class);
                int currentShoeID = shoeAdapter.getItem(position).getShoeID();
                intent1.putExtra(SHOE_KEY, currentShoeID);

                startActivity(intent1);
            }
        });

        fabAddNewShoe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(DisplayBrandActivity.this, AddObjectActivity.class);
                int[] extras = { 2, currentBrandID };
                intent2.putExtra(INT_ARRAY_KEY, extras);
                startActivity(intent2);
            }
        });

        btnDeleteBrand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataProvider.deleteBrand(currentBrand);
                Toast.makeText(DisplayBrandActivity.this, R.string.toast_brand_deleted, Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        fabEditBrand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(DisplayBrandActivity.this, AddObjectActivity.class);
                int[] extras = { 3, currentBrandID };
                intent2.putExtra(INT_ARRAY_KEY, extras);
                startActivity(intent2);
            }
        });

    }

    private void setTexts() {
        brandName.setText(currentBrand.getName());
        brandEstDate.setText(currentBrand.getEstablishmentDate());
        brandDetails.setText(currentBrand.getDetails());
    }

    private void setImage() {
        if(currentBrand.getImageUri() != null) {
            brandLogo.setImageURI(currentBrand.getImageUri());
        } else {
            brandLogo.setImageResource(currentBrand.getImageID());
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        setTexts();
        setImage();
        shoeAdapter.notifyDataSetChanged();
    }

}
