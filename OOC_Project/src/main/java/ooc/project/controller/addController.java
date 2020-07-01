package ooc.project.controller;


import ooc.project.entities.User;
import ooc.project.entities.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class addController {

    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    public void addingUser(@RequestBody User user) {
        userService.addUser(user);
    }
}
