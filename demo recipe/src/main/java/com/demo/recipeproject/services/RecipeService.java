package com.demo.recipeproject.services;

import com.demo.recipeproject.model.Recipe;

import java.util.Set;

/**
 * Created by @kmartin62
 */
public interface RecipeService {
    Set<Recipe> getRecipes();
}
