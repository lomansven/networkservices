package com.nike.mysneakerapp.Activities;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.nike.mysneakerapp.CompoundControls.AddDataView;
import com.nike.mysneakerapp.DataProvider.DataProvider;
import com.nike.mysneakerapp.CompoundControls.ImagePreview;
import com.nike.mysneakerapp.R;
import com.nike.mysneakerapp.models.Brand;
import com.nike.mysneakerapp.models.Shoe;

import static com.nike.mysneakerapp.Activities.DisplayBrandActivity.INT_ARRAY_KEY;

public class AddObjectActivity extends AppCompatActivity {
    private ImagePreview customImagePreviewBrand;

    private AddDataView addDataView;
    private TextView addObjectHeading;
    private Button btnSaveObject;
    private Button btnAddImage;
    private Uri currentObjectUri;
    private Brand currentBrand;
    private Shoe currentShoe;

    private int[] intentExtras;
    private int currentObjectID;
    private int objectKey;

    private static final int GALLERY_REQUEST_CODE = 1;
    private static final int READ_EXTERNAL_STORAGE_PERMISSION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_object);

        addObjectHeading = findViewById(R.id.tvAddObjectHeading);
        addDataView = findViewById(R.id.addObjectDataView);
        btnSaveObject = findViewById(R.id.btnSaveObject);
        btnAddImage = findViewById(R.id.btnAddImage);
        customImagePreviewBrand = findViewById(R.id.imagePreview);

        Intent intent = getIntent();
        intentExtras = intent.getIntArrayExtra(INT_ARRAY_KEY);

        objectKey = intentExtras[0];
        //objectKey == 1 means new Brand
        //objectKey == 2 means new Shoe
        //objectKey == 3 means edit Brand
        //objectKey == 4 means edit Shoe

        currentObjectID = intentExtras[1];

        if(objectKey == 1) {
            String[] hints = {getResources().getString(R.string.et_hint_brandname), getResources().getString(R.string.et_hint_brand_est_date), getResources().getString(R.string.et_hint_branddetails)};
            addDataView.setHints(hints);
            btnSaveObject.setText(getResources().getString(R.string.btn_addbrand));
            addObjectHeading.setText(getResources().getString(R.string.new_brand));
        } else if(objectKey == 2) {
            String[] hints = {getResources().getString(R.string.et_hint_shoename), getResources().getString(R.string.et_hint_shoe_release_date), getResources().getString(R.string.et_hint_shoedetails)};
            addDataView.setHints(hints);
            btnSaveObject.setText(getResources().getString(R.string.btn_addshoe));
            addObjectHeading.setText(getResources().getString(R.string.new_shoe));
        } else if(objectKey == 3) {
            currentBrand = DataProvider.getBrandByID(currentObjectID);
            addDataView.setTexts(currentBrand.getStrings());
            btnSaveObject.setText(getResources().getString(R.string.save_changes_btn));
            addObjectHeading.setText(getResources().getString(R.string.edit_brand_heading));
        } else if(objectKey == 4) {
            currentShoe = DataProvider.getShoeByID(currentObjectID);
            addDataView.setTexts(currentShoe.getStrings());
            btnSaveObject.setText(getResources().getString(R.string.save_changes_btn));
            addObjectHeading.setText(getResources().getString(R.string.edit_shoe_heading));
        }

        btnAddImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                askPermission();
            }
        });

        btnSaveObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(objectKey == 1) {
                    if(addDataView.isEmpty()) {
                        Toast.makeText(AddObjectActivity.this, R.string.add_brand_error, Toast.LENGTH_SHORT).show();
                    } else {
                        if(currentObjectUri != null) {
                            DataProvider.addBrand(new Brand(addDataView.getName(), addDataView.getDate(), addDataView.getDetails(), currentObjectUri));
                        } else {
                            DataProvider.addBrand(new Brand(addDataView.getName(), addDataView.getDate(), addDataView.getDetails()));
                        }

                        finish();
                    }


                } else if(objectKey == 2) {
                    if(addDataView.isEmpty()) {
                        Toast.makeText(AddObjectActivity.this, R.string.add_shoe_error, Toast.LENGTH_SHORT).show();
                    } else {
                        if(currentObjectUri != null) {
                            currentBrand.addUserCreatedShoe(new Shoe(addDataView.getName(), addDataView.getDate(), addDataView.getDetails(), currentObjectUri));
                        } else {
                            currentBrand.addUserCreatedShoe(new Shoe(addDataView.getName(), addDataView.getDate(), addDataView.getDetails()));
                        }

                        finish();
                    }


                } else if(objectKey == 3) {
                    if(addDataView.isEmpty()) {
                        Toast.makeText(AddObjectActivity.this, R.string.add_brand_error, Toast.LENGTH_SHORT).show();
                    } else {
                        currentBrand.setName(addDataView.getName());
                        currentBrand.setEstDate(addDataView.getDate());
                        currentBrand.setDetails(addDataView.getDetails());
                        currentBrand.setImageUri(currentObjectUri);

                        finish();
                    }

                } else if(objectKey == 4) {
                    if(addDataView.isEmpty()) {
                        Toast.makeText(AddObjectActivity.this, R.string.add_shoe_error, Toast.LENGTH_SHORT).show();
                    } else {
                        currentShoe.setName(addDataView.getName());
                        currentShoe.setReleaseDate(addDataView.getDate());
                        currentShoe.setDetails(addDataView.getDetails());
                        currentShoe.setShoeImgUri(currentObjectUri);

                        finish();
                    }

                }
            }
        });
    }

    /**
     * Permission to read the user's device's memory is asked here.
     * If permission is already granted, choosePicture() will be called.
     */
    private void askPermission() {
        /*
        This method asks for the permission to pick an image from the gallery,
        and if it has permission, lets the user choose pick the image too
         */
        if (ContextCompat.checkSelfPermission(AddObjectActivity.this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            //Check if the user has previously declined the permission
            if (ActivityCompat.shouldShowRequestPermissionRationale(AddObjectActivity.this,
                    Manifest.permission.READ_EXTERNAL_STORAGE)) {

                //If the user has previously declined permission, an explanation to why the
                //permission is needed is given
                Toast.makeText(this, R.string.no_permission_given_error_brand, Toast.LENGTH_SHORT).show();
            } else {
                // User hasn't granted nor declined the permission yet, request the permission for the first time..
                ActivityCompat.requestPermissions(AddObjectActivity.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        READ_EXTERNAL_STORAGE_PERMISSION );
            }
        } else {
            // Permission has already been granted
            chooseImage();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        // If request is cancelled, the result arrays are empty.
        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            //Permission was granted, chooseImage method called!
            chooseImage();
        } else {
            //Permission not granted..
            Toast.makeText(this, R.string.no_permission_error_brand, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Chooses an image from the user's gallery. Only the formats .jpeg and .png are supported.
     */
    private void chooseImage() {
        //Create an Intent with action as ACTION_PICK
        Intent intent = new Intent(Intent.ACTION_PICK);
        // Sets the type as image/*. This ensures only components of type image are selected
        intent.setType("image/*");
        //We pass an extra array with the accepted mime types. This will ensure only components with these MIME types as targeted.
        String[] mimeTypes = {"image/jpeg", "image/png"};
        intent.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes);
        // Launching the Intent
        startActivityForResult(intent,GALLERY_REQUEST_CODE);
    }

    /**
     * If the user has actually chosen an image, it will be shown on the screen as a preview.
     * The Uri of the new Brand will be set to the chosen picture
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        // Result code is RESULT_OK only if the user selects an Image
        if (resultCode == Activity.RESULT_OK)
            switch (requestCode){
                case GALLERY_REQUEST_CODE:
                    //data.getData returns the content URI for the selected Imaasge
                    currentObjectUri = data.getData();
                    customImagePreviewBrand.setImageURI(currentObjectUri);
                    customImagePreviewBrand.setHasPicture();
                    break;
            }

    }
}

