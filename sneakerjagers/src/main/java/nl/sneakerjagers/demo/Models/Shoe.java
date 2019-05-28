package nl.sneakerjagers.demo.Models;

import java.time.LocalDate;

public class Shoe {
    private static int nextID = 0;

    private String shoeName;
    private LocalDate releaseDate;
    private String details;
    private int shoeID;

    public Shoe() {
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
}
