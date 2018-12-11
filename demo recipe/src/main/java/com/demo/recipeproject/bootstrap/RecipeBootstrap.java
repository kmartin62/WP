package com.demo.recipeproject.bootstrap;

import com.demo.recipeproject.model.*;
import com.demo.recipeproject.repositories.CategoryRepository;
import com.demo.recipeproject.repositories.RecipeRepository;
import com.demo.recipeproject.repositories.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by @kmartin62
 */
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        recipeRepository.saveAll(getRecipes());
    }

    public RecipeBootstrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    private List<Recipe> getRecipes(){
        List<Recipe> recipes = new ArrayList<>(2);

        Recipe recipe = new Recipe();
        recipe.setDescription("TestDescription");
        recipe.setPrepTime(10);
        recipe.setCookTime(0);
        recipe.setServings(5);
        recipe.setSource("TestSource");
        recipe.setUrl("TestUrl");
        recipe.setDirections("TestDirections");
        recipe.setDifficulty(Difficulty.EASY);
        Set<Ingredient> t = new HashSet<>();
        t.add(new Ingredient("Test", new BigDecimal(5), new UnitOfMeasure("TestDescriptionUOM"), recipe));
        recipe.setIngredients(t);
        recipe.setNotes(new Notes(recipe, "RecipeNotes"));
        Set<Category> c = new HashSet<>();
        c.add(new Category("TestCategoryDesc"));
        recipe.setCategories(c);

        recipes.add(recipe);

//        @Enumerated(value = EnumType.STRING)
//        private Difficulty difficulty;
//        @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe") //ingredientot kje se zacuva na property recipe za da otide vo Ingredient klasata, da go najde recipe i da go vooci @ManyToOne
//        private Set<Ingredient> ingredients = new HashSet<>();
//
//        @Lob //long object binary
//        private Byte[] image;
//
//        @OneToOne(cascade = CascadeType.ALL) // cascade znaci ako se izbrise objekt od Recipe tip, da se izbrise i notes'ot od toj recept
//        private Notes notes;
//
//        @ManyToMany
//        @JoinTable(name = "recipe_category",
//                joinColumns = @JoinColumn(name = "recipe_id"),
//                inverseJoinColumns = @JoinColumn(name = "category_id"))
//        private Set<Category> categories = new HashSet<>();

        return recipes;
    }


}
