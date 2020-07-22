package ooc.project.entities;

import ooc.project.repository.IngredientRepository;
import ooc.project.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class IngredientMenuService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private MenuRepository menuRepository;

    public Integer getMenuIdByName(String menuName){
        List<Menu> menu=menuQuery(menuName);
        if(menu.size()==0){
            return -1;
        }
        return menu.get(0).getId();
    }

    public Set<String> getIngredientByMenu(String menuName){
        Integer id=getMenuIdByName(menuName);
        Set<String> nameSet=new HashSet<>();
        if(id!=-1) {
            Menu menu = entityManager.find(Menu.class, id);
            Set<Ingredient> ingredients = menu.getIngredientSet();
            for (Ingredient ing : ingredients) {
                nameSet.add(ing.getName());
            }
        }
        else{
            nameSet.add("Invalid Menu Name");
        }
        return nameSet;
    }

    public Integer getIngredientIdByName(String ingredientName){
        List<Ingredient> ingredient=ingredientQuery(ingredientName);
        if(ingredient.size()==0){
            return -1;
        }
        return ingredient.get(0).getId();
    }

    public Set<String> getMenuByIngredient(String ingredientName){
        Integer id=getIngredientIdByName(ingredientName);
        Set<String> nameSet=new HashSet<>();
        if (id != -1) {
            Ingredient ingredient = entityManager.find(
                    Ingredient.class, id);
            Set<Menu> menus = ingredient.getMenuSet();
            for (Menu ing : menus) {
                nameSet.add(ing.getName());
            }
        }
        else{
            nameSet.add("Invalid Ingredient Name");
        }
        return nameSet;
    }
    public List<Menu> menuQuery(String menuName){
        TypedQuery<Menu> query=entityManager.createQuery(
                "select c from Menu c where c.name = ?1",
                Menu.class);
        query.setParameter(1,menuName);
        return query.getResultList();
    }

    public List<Ingredient> ingredientQuery(String ingredientName ) {
        TypedQuery<Ingredient> query = entityManager.createQuery(
                "select c from Ingredient c where c.name = ?1",
                Ingredient.class);
        query.setParameter(1, ingredientName);
        return query.getResultList();
    }
    public String add(List<String> ingredients,String menuName){
        Set<Ingredient> ingredientSet=new HashSet<>();
        Set<Menu> menuSet=new HashSet<>();
        List<Menu> checkMenu=menuQuery(menuName);
        if(checkMenu.size()==0) {
            addMenu(ingredients,menuName);
            return "add success";
        }
        else{
            return "menu already exist";
        }
    }

    private void construct(List<String> ingredients, Set<Ingredient> ingredientSet, Set<Menu> menuSet, Menu menu) {
        for(String ingredientName: ingredients){
            List<Ingredient> checkIngredient=ingredientQuery(ingredientName);
            List<Menu> checkMenu=menuQuery(ingredientName);
            if(checkMenu.size()!=0){
                for(Ingredient ingredient:checkMenu.get(0).getIngredientSet()){
                    ingredient.getMenuSet().add(menu);
                    ingredientSet.add(ingredient);
                }
                continue;
            }
            if(checkIngredient.size()==0){
                Ingredient ing=new Ingredient();
                ing.setName(ingredientName);
                ing.setMenuSet(menuSet);
                ingredientSet.add(ing);
            }
            else{
                Ingredient ingredient= checkIngredient.get(0);
                ingredient.getMenuSet().add(menu);
                ingredientSet.add(ingredient);
            }
        }
        menu.getIngredientSet().addAll(ingredientSet);
        menuRepository.save(menu);
        ingredientRepository.saveAll(ingredientSet);
    }

    public void addMenu(List<String> ingredients,String menuName){
        Set<Menu> menuSet=new HashSet<>();
        Menu menu = new Menu();
        menu.setName(menuName);
        menu.setIngredientSet(new HashSet<>());
        menuSet.add(menu);
        Set<Ingredient> ingredientSet=new HashSet<>();
        construct(ingredients, ingredientSet, menuSet, menu);
    }
}