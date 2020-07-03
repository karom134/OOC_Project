package ooc.project.controller;

import ooc.project.entities.Ingredient;
import ooc.project.entities.IngredientMenuService;
import ooc.project.entities.User;
import ooc.project.entities.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
public class ingredientMenuController {

    @Autowired
    IngredientMenuService ingredientMenuService;

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

    @PostMapping("/getIngredient")
    public Set<String> getIngredientByMenu(@RequestBody Map<String, String> map) {
        return ingredientMenuService.getIngredientByMenu(map.get("menu_name"));
    }

    @PostMapping("/getMenu")
    public Set<String> getMenuByIngredient(@RequestBody Map<String, String> map) {
        return ingredientMenuService.getMenuByIngredient(map.get("ing1"));
    }
}
