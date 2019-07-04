package nl.sneakerjagers.demo;

import nl.sneakerjagers.demo.Models.Brand;
import nl.sneakerjagers.demo.Models.Shoe;
import nl.sneakerjagers.demo.Models.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/sneakerjagers")
public class AddStuffController {

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        if(user.getUsername()==null || user.getUsername().isEmpty()) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        DataProvider.addUser(user);

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PostMapping("/brands")
    public ResponseEntity<Brand> createBrand(@RequestBody Brand brand) {
        if(brand.getBrandName()==null || brand.getBrandName().isEmpty()) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        DataProvider.addBrand(brand);

        return new ResponseEntity<>(brand, HttpStatus.CREATED);
    }

    @PostMapping("/shoes")
    public ResponseEntity<Shoe> createShoe(Shoe shoe) {
        if(shoe.getShoeName()==null || shoe.getShoeName().isEmpty()) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        DataProvider.addShoe(shoe);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/shoes");

        return new ResponseEntity<>(headers, HttpStatus.SEE_OTHER);
    }

}
