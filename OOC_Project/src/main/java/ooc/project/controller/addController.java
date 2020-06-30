package ooc.project.controller;


import ooc.project.entities.User;
import ooc.project.entities.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class addController {

    @Autowired
    UserService userService;

    @GetMapping("/addUser")
    public void addingUser() {
        User user = new User();
        user.setUsername("Phang");
        user.setPassword("1234");
        userService.addUser(user);
    }
}
