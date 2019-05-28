package nl.sneakerjagers.demo.Models;

import java.util.ArrayList;

public class User {
    private static int nextID = 0;

    private String username;
    private String password;
    private String realName;
    private int userID;

    private ArrayList<Shoe> userCreatedShoes = new ArrayList<>();
    private ArrayList<Brand> userCreatedBrands = new ArrayList<>();

    public User() {
        this.userID = nextID;
        nextID++;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public ArrayList<Shoe> getUserCreatedShoes() {
        return userCreatedShoes;
    }

    public void setUserCreatedShoes(ArrayList<Shoe> userCreatedShoes) {
        this.userCreatedShoes = userCreatedShoes;
    }

    public ArrayList<Brand> getUserCreatedBrands() {
        return userCreatedBrands;
    }

    public void setUserCreatedBrands(ArrayList<Brand> userCreatedBrands) {
        this.userCreatedBrands = userCreatedBrands;
    }

    public int getUserID() {
        return userID;
    }
}
