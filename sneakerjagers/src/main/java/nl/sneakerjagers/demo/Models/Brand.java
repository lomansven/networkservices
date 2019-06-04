package nl.sneakerjagers.demo.Models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Brand {
    private static int nextID = 0;

    private String brandName;
    private LocalDate establishmentDate;
    private String details;
    private int brandID;

    private ArrayList<Shoe> shoes = new ArrayList<>();

    public Brand() {
        this.brandID = nextID;
        nextID++;
    }

    public Brand(String brandName, LocalDate establishmentDate, String details) {
        this.brandName = brandName;
        this.establishmentDate = establishmentDate;
        this.details = details;

        this.brandID = nextID;
        nextID++;
    }

    public void addShoe(Shoe s) {
        shoes.add(s);
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public LocalDate getEstablishmentDate() {
        return establishmentDate;
    }

    public void setEstablishmentDate(LocalDate establishmentDate) {
        this.establishmentDate = establishmentDate;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public ArrayList<Shoe> getShoes() {
        return shoes;
    }

    public void setShoes(ArrayList<Shoe> shoes) {
        this.shoes = shoes;
    }

    public int getBrandID() {
        return brandID;
    }
}

