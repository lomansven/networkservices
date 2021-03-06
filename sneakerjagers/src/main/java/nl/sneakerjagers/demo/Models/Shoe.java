package nl.sneakerjagers.demo.Models;

import java.time.LocalDate;

public class Shoe {
    private static int nextID = 0;

    private String shoeName;
    private LocalDate releaseDate;
    private String details;
    private String imagePath;
    private int shoeID;
    private Link link;
    private Brand brand;

    public Shoe() {
        this.shoeID = nextID;
        nextID++;
    }

    public Shoe(String shoeName, LocalDate releaseDate, String details) {
        this.shoeName = shoeName;
        this.releaseDate = releaseDate;
        this.details = details;

        this.shoeID = nextID;
        nextID++;
    }

    public Shoe(String shoeName, LocalDate releaseDate, String details, String imagePath) {
        this.shoeName = shoeName;
        this.releaseDate = releaseDate;
        this.details = details;
        this.imagePath = imagePath;

        this.shoeID = nextID;
        nextID++;
    }

    public String getShoeName() {
        return shoeName;
    }

    public void setShoeName(String shoeName) {
        this.shoeName = shoeName;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getShoeID() {
        return shoeID;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void addBrand(Brand brand) {
        this.brand = brand;
    }

}
