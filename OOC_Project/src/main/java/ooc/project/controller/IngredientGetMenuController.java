package ooc.project.controller;

import ooc.project.entities.IngredientMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IngredientGetMenuController {

    @Autowired
    IngredientMenuService ingredientMenuService;

    @GetMapping("/GetMenu")
    public String getMenuFromIngredient(ModelMap modelMap){
        String welcome = "Please enter your ingredients in order to get menu";
        modelMap.addAttribute("display",welcome);
        return "IngredientToMenu";
    }

    @PostMapping("/GetMenu")
    public String doGetMenu(@RequestParam String IngredientName, Model model) {
        model.addAttribute("display", ingredientMenuService.getMenuByIngredient(IngredientName));
        return "ReturnMenu";
    }
}
