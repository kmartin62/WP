package com.demo.recipeproject.repositories;

import com.demo.recipeproject.model.Recipe;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by @kmartin62
 */
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
