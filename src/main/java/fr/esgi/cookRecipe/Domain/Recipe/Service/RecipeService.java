package fr.esgi.cookRecipe.Domain.Recipe.Service;

import fr.esgi.cookRecipe.Domain.Recipe.Entity.Recipe;
import fr.esgi.cookRecipe.Domain.Recipe.Repository.RecipeRepository;
import kernel.NoSuchEntityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public void addRecipe(Recipe recipe) {
        this.saveRecipe(recipe);
    }

    public List<Recipe> getAllRecipes() {
        Iterable<Recipe> recipes = this.recipeRepository.findAll();
        return Streamable.of(recipes).toList();
    }

    public List<Recipe> getPaginatedRecipeList(Pageable pagination) {
        return this.recipeRepository.findAll(pagination).getContent();
    }

    public Recipe getRecipeById(UUID id) {
        Optional<Recipe> recipe = this.recipeRepository.findById(id);
        if(recipe.isEmpty()){
            throw NoSuchEntityException.withIdAndElem(id,"recipe");
        }
        return recipe.get();
    }

    public List<Recipe> getRecipesByName(String name){
        return this.recipeRepository.getRecipesByName(name);
    }

    public List<Recipe> getRecipesByUserId() {
        return null;
    }

    public void removeRecipeById(UUID id) {
        this.recipeRepository.delete(this.getRecipeById(id));
    }

    private void saveRecipe(Recipe recipe){
        this.recipeRepository.save(recipe);
    }
}
