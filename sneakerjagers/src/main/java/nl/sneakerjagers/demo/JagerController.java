package nl.sneakerjagers.demo;

import nl.sneakerjagers.demo.Models.Brand;
import nl.sneakerjagers.demo.Models.Shoe;
import nl.sneakerjagers.demo.Models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/sneakerjagers")
public class JagerController {

    private ArrayList<Brand> brands = DataProvider.brands;
    private ArrayList<Shoe> shoes = DataProvider.shoes;
    private ArrayList<User> users = DataProvider.users;

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        if(user.getUsername()==null) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        DataProvider.addUser(user);

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PostMapping("/brands")
    public ResponseEntity<Brand> createBrand(@RequestBody Brand brand) {
        if(brand.getBrandName()==null) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        DataProvider.addBrand(brand);

        return new ResponseEntity<>(brand, HttpStatus.CREATED);
    }

    @PostMapping("/shoes")
    public ResponseEntity<Shoe> createShoe(@RequestBody Shoe shoe) {
        if(shoe.getShoeName()==null) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        DataProvider.addShoe(shoe);

        return new ResponseEntity<>(shoe, HttpStatus.CREATED);
    }

    @GetMapping("/brands")
    public @ResponseBody String getBrands() {
        String retVal = "Brands: \n";
        if(brands.size()==0) {
            return retVal += "No brands have been created yet... Be the first!";
        }

        for (Brand brand : brands) {
            retVal+= "Brand: " + brand.getBrandName() + "\n";
        }
        return retVal;
    }

    @GetMapping("/shoes")
    public @ResponseBody String getShoes() {
        String retVal = "Shoes: \n";
        if(shoes.size()==0) {
            return retVal += "No shoes have been created yet... Be the first!";
        }

        for (Shoe shoe : shoes) {
            retVal += "Shoe: " + shoe.getShoeName() + "\n";
        }
        return retVal;
    }

    @GetMapping("/brands/shoes")
    public @ResponseBody String getBrandsWithShoes() {
        String retVal = "Brands: \n";
        if(brands.size()==0) {
            return retVal += "No brands have been created yet... Be the first!";
        }

        for (Brand brand : brands) {
            retVal += "Brand: " + brand.getBrandName() + "\n";

            ArrayList<Shoe> currentShoes = brand.getShoes();
            if(currentShoes.size()==0) {
                retVal+= "Brand does not contain any shoes yet... \n";
                continue;
            }

            for (Shoe shoe : currentShoes) {
                retVal += shoe.getShoeName() + "\n";
            }
        }
        return retVal;
    }
}
