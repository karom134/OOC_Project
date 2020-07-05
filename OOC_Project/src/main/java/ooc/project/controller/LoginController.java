//package ooc.project.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//public class LoginController {
//
//    @Autowired
//    private SecurityService securityService;
//
//    @GetMapping("/login")
//    public String loginForm(){
//        return "login";
//    }
//
//    @PostMapping("/login")
//    public String doLogin(@RequestParam String username,@RequestParam String password, Model model) {
//        if (securityService.login(username, password)) {
//            return "redirect:/MenuGetIngredient";
//        } else {
//            model.addAttribute("error", "Wrong username or password");
//            return "login";
//        }
//    }
//}
