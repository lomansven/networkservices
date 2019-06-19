package nl.sneakerjagers.demo;

import nl.sneakerjagers.demo.Models.Brand;
import nl.sneakerjagers.demo.Models.Link;
import nl.sneakerjagers.demo.Models.Shoe;
import nl.sneakerjagers.demo.Models.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/sneakerjagers")
public class JagerController {

    private ArrayList<Brand> brands = DataProvider.brands;
    private ArrayList<Shoe> shoes = DataProvider.shoes;
    private ArrayList<User> users = DataProvider.users;
    private ArrayList<Link> links = DataProvider.links;

    @GetMapping("/home")
    public String getHomeScreen(Model model) {
        model.addAttribute("links", links);
        model.addAttribute("shoes", shoes);
        model.addAttribute("brands", brands);
        return "layout";
    }

    @GetMapping("/brands")
    public String getBrands(Model model) {
        model.addAttribute("brands", brands);
        model.addAttribute("shoes", shoes);
        return "brands";
    }

    @GetMapping("/shoes")
    public String getShoes(Model model) {
        model.addAttribute("shoes", shoes);
        return "shoes";
    }

    @GetMapping("/{brandName}/shoes")
    public String getBrandWithShoes(@PathVariable("brandName") String brandName, Model model) {
        Brand currentBrand = null;
        for (Brand brand : brands) {
            if(brand.getBrandName().toLowerCase().equals(brandName.toLowerCase())) {
                currentBrand = brand;
                break;
            }
        }

        if(currentBrand == null) {
            throw new RuntimeException("Merk niet gevonden!");
        }

        model.addAttribute("currentBrand", currentBrand);
        return "brandShoes";

    }

}
