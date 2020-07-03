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

    public Set<String> getIngredientByMenu(String menuName) {
        Set<String> ingredientNameSet = new HashSet<>();
        TypedQuery<Menu> menuQuery = entityManager.createQuery("select c from Menu c where c.name =?1",Menu.class);
        menuQuery.setParameter(1,menuName);
        for (Ingredient ingredient : menuQuery.getResultList().get(0).getIngredientSet()) { //get the name of ingredient out of the IngredientSet in ingredient
            ingredientNameSet.add(ingredient.getName());
        }
        return ingredientNameSet;
    }

    public Set<String> getMenuByIngredient(String nameIngredient) {
        Set<String> MenuNameSet = new HashSet<>();
        TypedQuery<Ingredient> menuQuery = entityManager.createQuery("select c from Ingredient c where c.name =?1",Ingredient.class);
        menuQuery.setParameter(1,nameIngredient);
        for (Menu menu : menuQuery.getResultList().get(0).getMenuSet()) { //get the name of menu out of the MenuSet in menu
            MenuNameSet.add(menu.getName());
        }
        return MenuNameSet;
    }


    public void addOrUpdate(List<String> ingredients, String menuName) {
        Set<Ingredient> ingredientSet = new HashSet<>();
        Set<Menu> menuSet = new HashSet<>();
        TypedQuery<Menu> menuQuery = entityManager.createQuery("select c from Menu c where c.name = ?1", Menu.class);
        menuQuery.setParameter(1,menuName);
        List<Menu> checkMenu = menuQuery.getResultList();
        Menu menu;
        if(checkMenu.size()==0) { // if don't have to menu then it is going to be zero , we use list because we are not sure if the data exit in the database
            menu = new Menu();
            menu.setName(menuName); //set name for menu
            menu.setIngredientSet(new HashSet<>()); //set ingredientSet into menu
            menuSet.add(menu);
        }
        else {
            menu=checkMenu.get(0); // get that menu out , we are sure that it is just only one menu in there because the name is unique
        }
        for(String ingredientName: ingredients) {
            TypedQuery<Ingredient> query = entityManager.createQuery("select c from Ingredient c where c.name =?1",Ingredient.class);
            query.setParameter(1,ingredientName); // find the ingredient
            List<Ingredient> checkIngredient = query.getResultList();
            if(checkIngredient.size() == 0){
                Ingredient ing = new Ingredient();
                ing.setName(ingredientName);
                ing.setMenuSet(menuSet); //ingredient might be use with lots of menu
                ingredientSet.add(ing);
            }
            else {
                Ingredient ingredient = checkIngredient.get(0);
                ingredient.getMenuSet().add(menu); // this ingredient do which menu
                ingredientSet.add(ingredient);
            }
        }
        menu.getIngredientSet().addAll(ingredientSet);
        menuRepository.save(menu);
        ingredientRepository.saveAll(ingredientSet);
    }
}
