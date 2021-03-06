package nl.sneakerjagers.demo;

import nl.sneakerjagers.demo.Models.Brand;
import nl.sneakerjagers.demo.Models.Link;
import nl.sneakerjagers.demo.Models.Shoe;
import nl.sneakerjagers.demo.Models.User;

import java.time.LocalDate;
import java.util.ArrayList;

public class DataProvider {

    public static ArrayList<Shoe> shoes = new ArrayList<>();
    public static ArrayList<Brand> brands = new ArrayList<>();
    public static ArrayList<User> users = new ArrayList<>();
    public static ArrayList<Link> links = new ArrayList<>();

    static {
        //TODO add some shoes, brands and users
        addUser(new User("lomansven", "1234", "Sven Loman"));
        addUser(new User("ducviet", "1234", "Ducviet Dinhvan"));

        addBrand(new Brand("Nike", LocalDate.of(1964, 1, 25), "Swoosh"));
        addBrand(new Brand("Adidas", LocalDate.of(1949, 9, 18), "Three stripes"));

        //Nike shoes
        addShoeToBrand("nike", new Shoe("Nike x Off-White Airforce 1", LocalDate.of(2018, 12, 19), "Very nice", "af1_ow.jpg"));
        addShoeToBrand("nike", new Shoe("Nike x Off-White AirMax 90", LocalDate.of(2019, 2, 7), "In a black and desert colorway!", "am90_ow.jpg"));
        addShoeToBrand("nike", new Shoe("Nike x Sean Wotherspoon AirMax 97/1", LocalDate.of(2018, 3, 26), "An AirMax 97 shoe, with the sole of an AirMax 1! Designed by Sean Wotherspoon.", "am1_seanwotherspoon.jpg"));
        addShoeToBrand("nike", new Shoe("Nike x Parra AirMax 1", LocalDate.of(2019, 7, 21), "Designed by Amsterdam artist Piet Parra", "am1_parra.jpg"));
        addShoeToBrand("nike", new Shoe("Nike x Travis Scott AirJordan 1", LocalDate.of(2019, 2, 11), "Reversed swoosh :O", "aj1_travisscott.jpg"));

        //Adidas shoes
        addShoeToBrand("adidas", new Shoe("Adidas Yeezy 350 V2 Triple Black Reflective", LocalDate.of(2019, 6, 7), "Shining in the dark", "yeezy350_v2_blackreflective.png"));

        //Adds all the links for the 'Quick Links column'
        links.add(new Link("Home", "/sneakerjagers/home"));
        links.add(new Link("All brands", "/sneakerjagers/brands"));
        links.add(new Link("All shoes","/sneakerjagers/shoes"));
        for (Brand brand : brands) {
            links.add(new Link(brand.getBrandName(), "/sneakerjagers/" + brand.getBrandName().toLowerCase() + "/shoes"));
        }
        for (Shoe shoe : shoes) {

        }

    }

    public static void addShoe(Shoe s) {
        shoes.add(s);
    }

    public static void addShoeToBrand(String brandName, Shoe s) {
        shoes.add(s);
        for (Brand brand : brands) {
            if(brand.getBrandName().toLowerCase().trim().equals(brandName.toLowerCase().trim())) {
                brand.addShoe(s);
                s.addBrand(brand);
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

    public static Brand getBrandFromName(String name) {
        for (Brand brand : brands) {
            if(brand.getBrandName().toLowerCase().equals(name.toLowerCase())) {
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

    public static ArrayList<Brand> getBrands() {
        return brands;
    }

    public static ArrayList<Shoe> getShoes() {
        return shoes;
    }
}
