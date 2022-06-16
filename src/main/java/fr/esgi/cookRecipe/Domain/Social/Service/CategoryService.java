package fr.esgi.cookRecipe.Domain.Social.Service;

import fr.esgi.cookRecipe.Domain.Recipe.Entity.Recipe;
import fr.esgi.cookRecipe.Domain.Social.Entity.Category;
import fr.esgi.cookRecipe.Domain.Social.Repository.CategoryRepository;
import kernel.NoSuchEntityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void addCategory(Category category) {
        this.saveCategory(category);
    }

    public List<Category> getAllCategories() {
        return this.categoryRepository.findAll();
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

    public void recipeExist(UUID id){
        this.getRecipeById(id);
    }

    private void saveCategory(Category category){
        this.categoryRepository.save(category);
    }
}
