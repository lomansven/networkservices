package nl.sneakerjagers.demo;

import nl.sneakerjagers.demo.Models.Brand;
import nl.sneakerjagers.demo.Models.Shoe;
import nl.sneakerjagers.demo.Models.User;

import java.time.LocalDate;
import java.util.ArrayList;

public class DataProvider {

    public static ArrayList<Shoe> shoes = new ArrayList<>();
    public static ArrayList<Brand> brands = new ArrayList<>();
    public static ArrayList<User> users = new ArrayList<>();

    static {
        //TODO add some shoes, brands and users
        addUser(new User("lomansven", "1234", "Sven Loman"));

        addBrand(new Brand("Nike", LocalDate.of(1964, 1, 25), "Swoosh"));

        addShoeToBrand("nike", new Shoe("Nike x Off-White Airforce 1", LocalDate.of(2018, 12, 19), "Very nice"));
        addShoeToBrand("nike", new Shoe("Nike x Off-White AirMax 90", LocalDate.of(2019, 2, 7), "In a black and desert colorway!"));

        addShoe(new Shoe("Adidas Yeezy 350 V2 Triple Black Reflective", LocalDate.of(2019, 6, 7), "Shining in the dark"));


    }

    public static void addShoe(Shoe s) {
        shoes.add(s);
    }

    public static void addShoeToBrand(String brandName, Shoe s) {
        shoes.add(s);
        for (Brand brand : brands) {
            if(brand.getBrandName().toLowerCase().trim().equals(brandName.toLowerCase().trim())) {
                brand.addShoe(s);
            }
        }
    }

    public static void addBrand(Brand b) {
        brands.add(b);
    }

    public static void addUser(User u) {
        users.add(u);
    }

    public static Shoe getShoeFromID(int id) {
        for (Shoe shoe : shoes) {
            if (shoe.getShoeID() == id) {
                return shoe;
            }
        }
        return null;
    }

    public static Brand getBrandFromID(int id) {
        for (Brand brand : brands) {
            if (brand.getBrandID() == id) {
                return brand;
            }
        }
        return null;
    }

    public static User getUseerFromID(int id) {
        for (User user : users) {
            if (user.getUserID() == id) {
                return user;
            }
        }
        return null;
    }


}