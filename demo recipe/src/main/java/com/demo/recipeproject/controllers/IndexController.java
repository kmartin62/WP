package com.demo.recipeproject.controllers;

import com.demo.recipeproject.model.Category;
import com.demo.recipeproject.model.UnitOfMeasure;
import com.demo.recipeproject.repositories.CategoryRepository;
import com.demo.recipeproject.repositories.RecipeRepository;
import com.demo.recipeproject.repositories.UnitOfMeasureRepository;
import com.demo.recipeproject.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

/**
 * Created by @kmartin62
 */
@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model){

        model.addAttribute("recipes", recipeService.getRecipes());

        return "index";
    }

}
