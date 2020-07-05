package ooc.project.controller;

import ooc.project.entities.IngredientMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class IngredientMenuController {

    @Autowired
    IngredientMenuService ingredientMenuService;

    @GetMapping("/GetIng")
    public String getIngredientFromMenu(ModelMap modelMap){
        String welcome = "Please enter your menu in order to get ingredients";
        modelMap.addAttribute("display",welcome);
        return "MenuGetIngredient";
    }

    @PostMapping("/GetIng")
    public String doGetIngredient(@RequestParam String menuName, Model model) {
        model.addAttribute("display", ingredientMenuService.getIngredientByMenu(menuName));
        return "ReturnIngredient";
    }

//    @PostMapping("/getIngredient")
//    public Set<String> getIngredientByMenu(@RequestBody Map<String, String> map) {
//        return ingredientMenuService.getIngredientByMenu(map.get("menu_name"));
//    }
//
//    @PostMapping("/getMenu")
//    public Set<String> getMenuByIngredient(@RequestBody Map<String, String> map) {
//        return ingredientMenuService.getMenuByIngredient(map.get("ing1"));
//    }
}
