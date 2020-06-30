package ooc.project.controller;

import ooc.project.entities.User;
import ooc.project.entities.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/allUser")
    public List<User> getUser() {
        return userService.getAllUser();
    }

    @GetMapping("/getUser")
    public List<User> getOneUser() {
        return userService.getUserByUsername("maylin");
    }

}
