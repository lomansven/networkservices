package com.nike.mysneakerapp.models;

import android.net.Uri;

import java.util.ArrayList;
import java.util.List;

public class Shoe {
    private static int nextID = 0;

    private int brandID;

    private int shoeID;
    private String name;
    private String releaseDate;
    private String details;
    private int coverImageID;
    private Uri shoeImgUri;
    private boolean userCreated;

    public Shoe() {
        this.shoeID = nextID;
        nextID++;
    }

    public Shoe(String shoeName, String shoeReleaseDate, String shoeDetails) {
        this.name = shoeName;
        this.releaseDate = shoeReleaseDate;
        this.details = shoeDetails;

        this.shoeID = nextID;
        nextID++;
    }

    public Shoe(String shoeName, String shoeReleaseDate, String shoeDetails, Uri shoeImgUri) {
        this.name = shoeName;
        this.releaseDate = shoeReleaseDate;
        this.details = shoeDetails;
        this.shoeImgUri = shoeImgUri;

        this.shoeID = nextID;
        nextID++;
    }

    public Shoe(String shoeName, String shoeReleaseDate, String shoeDetails, int shoeImgID) {
        this.name = shoeName;
        this.releaseDate = shoeReleaseDate;
        this.details = shoeDetails;
        this.coverImageID = shoeImgID;

        this.shoeID = nextID;
        nextID++;
    }

    public int getShoeID() {
        return shoeID;
    }

    public String getName() {
        return name;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getDetails() {
        return details;
    }

    public int getImageID() {
        return coverImageID;
    }

    public Uri getShoeImgUri() {
        return shoeImgUri;
    }

    public int getBrandID() {
        return brandID;
    }

    public String[] getStrings() {
        String[] strings = { name, releaseDate, details };
        return strings;
    }

    protected void setBrandID(int brandID) {
        this.brandID = brandID;
    }

    protected void setAsUserCreated() {
        this.userCreated = true;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setShoeImgUri(Uri shoeImgUri) {
        this.shoeImgUri = shoeImgUri;
    }
}
