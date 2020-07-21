package ooc.project.controller;

import ooc.project.entities.User;
import ooc.project.entities.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class RegisterController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/api/register")
    public String registerForm() {
        return "test message";
    }

    @PostMapping("/api/register")
    public void doRegister(@RequestBody Map<String,String> map) {
        String username=map.get("username");
        String password=map.get("password");
//        System.out.println(username);
        User user=new User();
        user.setRole("ROLE_USER");
        user.setEnabled(1);
        user.setPassword(passwordEncoder.encode(password));
        user.setUsername(username);
        userService.addUser(user);
        //send error message

    }
}
