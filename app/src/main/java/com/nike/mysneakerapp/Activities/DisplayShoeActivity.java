package com.nike.mysneakerapp.Activities;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.nike.mysneakerapp.DataProvider.DataProvider;
import com.nike.mysneakerapp.R;
import com.nike.mysneakerapp.models.Brand;
import com.nike.mysneakerapp.models.Shoe;

import static com.nike.mysneakerapp.Activities.DisplayBrandActivity.INT_ARRAY_KEY;

public class DisplayShoeActivity extends AppCompatActivity {
    private Button btnDeleteShoe;
    private TextView shoeName;
    private TextView shoeRD;
    private TextView shoeDetails;
    private ImageView shoeCoverImg;
    private Shoe currentShoe;
    private Brand currentBrand;
    private FloatingActionButton fabEditShoe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_shoe);

        Intent intent = getIntent();

        int currentID = intent.getIntExtra(DisplayBrandActivity.SHOE_KEY, -1);
        if(currentID != -1) {
            currentShoe = DataProvider.getShoeByID(currentID);
            currentBrand = DataProvider.getBrandByID(currentShoe.getBrandID());
        } else {
            Toast.makeText(this, R.string.shoe_not_found_error, Toast.LENGTH_SHORT).show();
        }

        shoeName = findViewById(R.id.tvShoeName);
        shoeRD = findViewById(R.id.tvShoeRD);
        shoeDetails = findViewById(R.id.tvShoeDetails);
        shoeCoverImg = findViewById(R.id.ivShoePicture);
        btnDeleteShoe = findViewById(R.id.btnDeleteShoe);
        fabEditShoe = findViewById(R.id.fabEditShoe);

        shoeName.setText(currentShoe.getName());
        shoeRD.setText(currentShoe.getReleaseDate());
        shoeDetails.setText(currentShoe.getDetails());

        shoeDetails.setMovementMethod(new ScrollingMovementMethod());

        setTexts();
        setImage();

        btnDeleteShoe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentBrand.removeShoe(currentShoe);
                Toast.makeText(DisplayShoeActivity.this, R.string.toast_shoe_deleted, Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        fabEditShoe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(DisplayShoeActivity.this, AddObjectActivity.class);
                int[] extras = { 4, currentShoe.getShoeID() };
                intent2.putExtra(INT_ARRAY_KEY, extras);
                startActivity(intent2);
            }
        });

    }

    private void setTexts() {
        shoeName.setText(currentShoe.getName());
        shoeRD.setText(currentShoe.getReleaseDate());
        shoeDetails.setText(currentShoe.getDetails());
    }

    private void setImage() {
        if(currentShoe.getShoeImgUri() != null) {
            shoeCoverImg.setImageURI(currentShoe.getShoeImgUri());
        } else {
            shoeCoverImg.setImageResource(currentShoe.getImageID());
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        setTexts();
        setImage();
    }
}
