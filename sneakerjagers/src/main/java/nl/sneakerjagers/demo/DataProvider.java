package nl.sneakerjagers.demo;

import nl.sneakerjagers.demo.Models.Brand;
import nl.sneakerjagers.demo.Models.Shoe;
import nl.sneakerjagers.demo.Models.User;

import java.util.ArrayList;

public class DataProvider {

    public static ArrayList<Shoe> shoes = new ArrayList<>();
    public static ArrayList<Brand> brands = new ArrayList<>();
    public static ArrayList<User> users = new ArrayList<>();

    static {
        //TODO add some shoes, brands and users



    }

    public static void addShoe(Shoe s) {
        shoes.add(s);
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
