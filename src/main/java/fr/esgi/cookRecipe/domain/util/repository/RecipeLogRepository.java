package fr.esgi.cookRecipe.domain.util.repository;

import fr.esgi.cookRecipe.domain.recipe.entity.Recipe;
import fr.esgi.cookRecipe.domain.util.entity.RecipeLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface RecipeLogRepository extends PagingAndSortingRepository<RecipeLog, UUID> {
    RecipeLog getRecipeLogByRecipe(Recipe recipe);
    Page<RecipeLog>  getRecipeLogByRecipe_NameContainingAndCountLessThan(String name, Pageable pageable, int count);
    Page<RecipeLog> getRecipeLogByRecipe_NameContainingOrderByCountDesc(String name, Pageable pageable);
}
