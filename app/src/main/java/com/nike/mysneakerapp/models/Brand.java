package com.nike.mysneakerapp.models;

import android.net.Uri;

import java.util.ArrayList;
import java.util.List;

public class Brand {
    private static int nextBrandID = 0;

    private int brandID;
    private String name;
    private String establishmentDate;
    private String details;
    private int imageID;
    private Uri imageUri;

    private List<Shoe> shoes = new ArrayList<>();

    public Brand() {}

    public Brand(String name, String establishmentDate, String details) {
        this.name = name;
        this.establishmentDate = establishmentDate;
        this.details = details;

        this.brandID = nextBrandID;
        nextBrandID++;
    }

    public Brand(String name, String establishmentDate, String details, Uri imageUri) {
        this.name = name;
        this.establishmentDate = establishmentDate;
        this.details = details;
        this.imageUri = imageUri;

        brandID = nextBrandID;
        nextBrandID++;
    }

    public Brand(String name, String establishmentDate, String details, int imageResourceID) {
        this.name = name;
        this.establishmentDate = establishmentDate;
        this.details = details;
        this.imageID = imageResourceID;

        brandID = nextBrandID;
        nextBrandID++;
    }

    public void addShoe(Shoe s) {
        s.setBrandID(brandID);
        shoes.add(s);
    }

    public void addUserCreatedShoe(Shoe s) {
        s.setBrandID(brandID);
        s.setAsUserCreated();
        shoes.add(s);
    }

    public int getBrandID() {
        return brandID;
    }

    public String getName() {
        return name;
    }

    public String getEstablishmentDate() {
        return establishmentDate;
    }

    public String getDetails() {
        return details;
    }

    public Uri getImageUri() { return imageUri; }

    public List<Shoe> getShoeList() {
        return shoes;
    }

    public int getImageID() {
        return imageID;
    }

    public void removeShoe(Shoe s) {
        shoes.remove(s);
    }

    public int getNumberOfShoesInt() {
        return shoes.size();
    }

    public String[] getStrings() {
        String[] strings = { name, establishmentDate, details };
        return strings;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEstDate(String establishmentDate) {
        this.establishmentDate = establishmentDate;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setImageUri(Uri imageUri) {
        this.imageUri = imageUri;
    }
}
