package ooc.project.controller;

import ooc.project.entities.User;
import ooc.project.entities.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class XXXController {
    @Autowired
    UserService userService;
    @PostMapping("/api/xxx")
    public List<User> getUser(@RequestBody XXXDeo x) {
        System.out.println(x.getUsername());
        return userService.getAllUser();
    }
}
