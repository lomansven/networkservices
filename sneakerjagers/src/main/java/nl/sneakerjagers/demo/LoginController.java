package nl.sneakerjagers.demo;


import nl.sneakerjagers.demo.Models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

import static nl.sneakerjagers.demo.DataProvider.users;


@Controller
public class LoginController {

   @GetMapping(value = "/login")
    public String User(){
        return "layout";
    }

    @PostMapping(value = "/login")
    public String login(User user, Model model, HttpServletRequest request){

       String username = user.getUsername();
       String password = user.getPassword();

        for (User userToBeFound: users) {
            if (username.equals(userToBeFound.getUsername()) && password.equals(userToBeFound.getPassword())){
                return request.getRequestURI();
            }
        }
        model.addAttribute("invalidCredentials", true);
        return request.getRequestURI();


    }

}
