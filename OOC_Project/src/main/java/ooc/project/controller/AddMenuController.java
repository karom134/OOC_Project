package ooc.project.controller;

import ooc.project.entities.IngredientMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class AddMenuController {

    @Autowired
    IngredientMenuService ingredientMenuService;

    @PostMapping("/api/addMenu")
    public void addMenu(@RequestBody Map<String, String> map) {
        List<String> lst = new ArrayList<>();
        for (String key : map.keySet()) {
            if (!key.equals("menu_name")) {
                lst.add(map.get(key)); // add ingredient in to the lst
            }
        }
        ingredientMenuService.addOrUpdate(lst, map.get("menu_name"));
    }
}
