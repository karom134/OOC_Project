package ooc.project.controller;

import ooc.project.entities.Ingredient;
import ooc.project.entities.IngredientMenuService;
import ooc.project.entities.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class IngredientGetMenuController {

    @Autowired
    IngredientMenuService ingredientMenuService;

    @PostMapping("/getMenu")
    public List<Map<String,List<String>>> doGetMenu(@RequestBody Map<String,String> map){
        List<Set<String>> temporaryStorage=new ArrayList<>();
        for(String ingredient: map.values()){
            temporaryStorage.add(ingredientMenuService.getMenuByIngredient(ingredient));
        }
        return helper(temporaryStorage);
    }

    public List<Map<String,List<String>>> helper(List<Set<String>> arr){
        Set<String> finalSet=new HashSet<>();
        Map<Integer,List<String>> scoreMap=new HashMap<>();
        List<Map<String,List<String>>> finalList=new ArrayList<>();
        for(Set<String> set:arr){
            finalSet.addAll(set);
        }
        for(String name:finalSet){
            Integer score=computeScore(name,arr);
            if(!scoreMap.keySet().contains(score)){
                scoreMap.put(score,new ArrayList<>());
            }
            scoreMap.get(score).add(name);
        }
        for(int s=arr.size();s>0;s--){
            for(String name:scoreMap.getOrDefault(s,new ArrayList<>())){
                Map<String,List<String>> map=new HashMap<>();
                List<Menu> menuList=ingredientMenuService.menuQuery(name);
                map.put("menuName",new ArrayList<>());
                map.get("menuName").add(menuList.get(0).getName());
                List<String> keeper=new ArrayList<>();
                for(Ingredient ingredient:menuList.get(0).getIngredientSet()){
                    keeper.add(ingredient.getName());
                }
                map.put("ingLst",keeper);
                finalList.add(map);
            }
            if(finalList.size()>10){
                break;
            }
        }
        return finalList;
    }

    public Integer computeScore(String menu,List<Set<String>> arr){
        Integer score=0;
        for(Set<String> set:arr){
            if(set.contains(menu)){
                score++;
            }
        }
        return score;
    }
}
