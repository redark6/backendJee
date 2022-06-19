package fr.esgi.cookRecipe.Domain.Recipe.Repository;

import fr.esgi.cookRecipe.Domain.Recipe.Entity.Recipe;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface RecipeRepository extends PagingAndSortingRepository<Recipe, UUID> {
    List<Recipe> getRecipesByName(String name);

    //select * from recipes where
    //List<Recipe> getRecipesByPro(String name);
    //List<Recipe> getRecipesBy(String name);
}
