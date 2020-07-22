package ooc.project.controller;

import ooc.project.entities.IngredientMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class IngredientGetMenuController {

    @Autowired
    IngredientMenuService ingredientMenuService;

    @GetMapping("/api/GetMenu")
    public void getMenuFromIngredient(ModelMap modelMap){
    }

    @PostMapping("/api/GetMenu")
    public List<Map<String, List<String>>> doGetMenu(@RequestBody Map<String,String> map) {
        List<Map<String, List<String>>> finalMenu = new ArrayList<>();
        Set<String> finalSetMenu = new HashSet<>();
        for (String ingredient : map.values()) {
            Set<String> setMenu = ingredientMenuService.getMenuByIngredient(ingredient);
            finalSetMenu.addAll(setMenu);
        }
        for (String menu : finalSetMenu) {
            List<String> singleMenu = new ArrayList<>();
            singleMenu.add(menu);
            Map<String, List<String>> menuMap = new HashMap<>();
            menuMap.put("menuName",singleMenu);
            List<String> ingArray = new ArrayList<>(ingredientMenuService.getIngredientByMenu(menu));
            menuMap.put("ing_lst",ingArray);
            finalMenu.add(menuMap);
        }
        return finalMenu;
    }
}
