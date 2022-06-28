package fr.esgi.cookRecipe.domain.recipe.service;

import fr.esgi.cookRecipe.domain.recipe.entity.Recipe;
import fr.esgi.cookRecipe.domain.recipe.repository.RecipeRepository;
import fr.esgi.cookRecipe.domain.user.entity.UserAccount;
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

    public Recipe addRecipe(Recipe recipe) {
        return this.saveRecipe(recipe);
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

    public List<Recipe> getRecipesByName(String name, Pageable pagination){
        Iterable<Recipe> recipes = this.recipeRepository.findAllByNameContaining(name, pagination);
        return Streamable.of(recipes).toList();
    }

    public List<Recipe> getRecipesByProductId(UUID id, Pageable pagination){
        Iterable<Recipe> recipes = this.recipeRepository.findAllByProducts_Product_Id(id, pagination);
        return Streamable.of(recipes).toList();
    }

    public List<Recipe> getRecipesByProductName(String name, Pageable pagination){
        Iterable<Recipe> recipes = this.recipeRepository.findAllByProducts_Product_NameContaining(name, pagination);
        return Streamable.of(recipes).toList();
    }

    public List<Recipe> getRecipesByUser(UserAccount user){
        Iterable<Recipe> recipes = this.recipeRepository.findAllByUser(user);
        return Streamable.of(recipes).toList();
    }

    public int getUserRecipeCount(UserAccount user) {
        return this.recipeRepository.countByUser(user);
    }

    public void removeRecipeById(UUID id) {
        this.recipeRepository.delete(this.getRecipeById(id));
    }

    private Recipe saveRecipe(Recipe recipe){
        return this.recipeRepository.save(recipe);
    }
}
