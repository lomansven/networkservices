package nl.sneakerjagers.demo.Models;

import java.time.LocalDate;

public class Shoe {
    private String shoeName;
    private LocalDate releaseDate;
    private String details;

    public Shoe() {
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
}
