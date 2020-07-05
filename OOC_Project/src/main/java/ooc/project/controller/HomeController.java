package ooc.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String homeForm(){
        return "HomePage";
    }

    @PostMapping("/home")
    public String doGetIng(@RequestParam(value = "button") String button, Model model) {
        if (button.equalsIgnoreCase("getIng")) {
            return "redirect:/GetIng";
        }
        else {
            return "redirect:/GetMenu";
        }
    }
}
