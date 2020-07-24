package ooc.project.controller;

import ooc.project.entities.User;
import ooc.project.entities.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    UserService userService;

    @GetMapping("/api/login")
    public void loginForm(){
    }

    @PostMapping("/api/login")
    public String doLogin(@RequestBody Map<String,String> map){
        String username=map.get("username");
        String password=map.get("password");
        User user=userService.getUserByUsername(username);
        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        if(user==null){
            return "fail";
        }
        if(passwordEncoder.matches(password,user.getPassword())){
            return "Success";
        }
        else{
            return "fail";
        }
    }
}