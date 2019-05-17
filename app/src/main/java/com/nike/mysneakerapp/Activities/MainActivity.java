package com.nike.mysneakerapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.nike.mysneakerapp.R;

public class MainActivity extends AppCompatActivity {

    private Button goToBrands;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goToBrands = findViewById(R.id.btnGoToBrands);

        goToBrands.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BrandListActivity.class);
                startActivity(intent);
            }
        });

    }

}
