package ooc.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @GetMapping("/api//home")
    public String homeForm(){
        return "HomePage";
    }

    @PostMapping("/api//home")
    public String doGetIng(@RequestParam(value = "button") String button, Model model) {
        if (button.equalsIgnoreCase("getIng")) {
            return "redirect:/api/GetIng";
        }
        else {
            return "redirect:/api/GetMenu";
        }
    }
}
