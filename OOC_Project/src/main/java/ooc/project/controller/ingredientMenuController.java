package ooc.project.controller;

import ooc.project.entities.Ingredient;
import ooc.project.entities.IngredientMenuService;
import ooc.project.entities.User;
import ooc.project.entities.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
public class ingredientMenuController {

    @Autowired
    IngredientMenuService ingredientMenuService;

    @GetMapping("/MenuGetIngredient")
    public String getIngredientFromMenu(ModelMap modelMap){
        String welcome = "Welcome";
        modelMap.addAttribute("display",welcome);
        return "MenuGetIngredient";
    }

    @PostMapping("/MenuGetIngredient")
    public String After(@RequestParam String menuName, Model model) {
        model.addAttribute("display", ingredientMenuService.getIngredientByMenu(menuName));
        return "GetIngredient";
    }

    @PostMapping("/addMenu")
    public void addMenu(@RequestBody Map<String, String> map) {
        List<String> lst = new ArrayList<>();
        for (String key : map.keySet()) {
            if (!key.equals("menu_name")) {
                lst.add(map.get(key)); // add ingredient in to the lst
            }
        }
        ingredientMenuService.addOrUpdate(lst, map.get("menu_name"));
    }

//    @PostMapping("/getIngredient")
//    public Set<String> getIngredientByMenu(@RequestBody Map<String, String> map) {
//        return ingredientMenuService.getIngredientByMenu(map.get("menu_name"));
//    }

    @PostMapping("/getMenu")
    public Set<String> getMenuByIngredient(@RequestBody Map<String, String> map) {
        return ingredientMenuService.getMenuByIngredient(map.get("ing1"));
    }
}
