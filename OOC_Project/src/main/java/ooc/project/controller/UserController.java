package ooc.project.controller;

import ooc.project.entities.User;
import ooc.project.entities.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("register")
    public List<User> getUser() {
        return userService.getAllUser();
    }

    @GetMapping("/getUser")
    public User getOneUser(@RequestParam String username) {
        return userService.getUserByUsername(username);
    }
    @PostMapping("/addUser")
    public void addingUser(@RequestBody User user) {
        userService.addUser(user);
    }

}
