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
    ResponseEntity<User> createUser(@RequestBody User user) {
        if(user.getUsername()==null) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        users.add(user);

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PostMapping("/brands")
    ResponseEntity<Brand> createBrand(@RequestBody Brand brand) {
        if(brand.getBrandName()==null) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        brands.add(brand);

        return new ResponseEntity<>(brand, HttpStatus.CREATED);
    }

    @PostMapping("/shoes")
    ResponseEntity<Shoe> createShoe(@RequestBody Shoe shoe) {
        if(shoe.getShoeName()==null) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        shoes.add(shoe);

        return new ResponseEntity<>(shoe, HttpStatus.CREATED);
    }

    @GetMapping("/brands")
    public @ResponseBody String getBrands() {
        String retVal = "Brands: \n";
        if(brands.size()==0) return retVal+= "No brands have been created yet... Be the first!";
        for (Brand brand : brands) {
            retVal+= "Brand: " + brand.getBrandName() + "\n";

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
