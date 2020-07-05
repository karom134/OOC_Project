package ooc.project.controller;

import ooc.project.entities.User;
import ooc.project.entities.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String registerForm(){
        return "Register";
    }

    @PostMapping("/register")
    public String doRegister(@RequestParam String username, @RequestParam String password, Model model) {
        if (!userService.checkIfUserExits(username)) {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            userService.addUser(user);
            model.addAttribute("error", "Successful Registration");
            return "Register";
        }
        else {
            model.addAttribute("error", "Your username is already exit in the database");
            return "Register";
        }
    }
}
