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

@RestController
public class AddMenuController {

    @Autowired
    IngredientMenuService ingredientMenuService;

    @PostMapping("/api/add")
    public String addOrUpdateMenu(@RequestBody Map<String,List<String>> map){
        String menuName=map.get("menuName").get(0);
        List<String> ingredients=map.get("ingLst");
        return ingredientMenuService.add(ingredients,menuName);
    }
}
