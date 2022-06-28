package fr.esgi.cookRecipe.domain.social.service;

import fr.esgi.cookRecipe.domain.social.entity.Category;
import fr.esgi.cookRecipe.domain.social.repository.CategoryRepository;
import kernel.NoSuchEntityException;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Category getCategoryById(UUID id) {
        Optional<Category> category = this.categoryRepository.findById(id);
        if(category.isEmpty()){
            throw NoSuchEntityException.withIdAndElem(id,"category");
        }
        return category.get();
    }
/*
    public List<Recipe> getRecipesByName(String name){
        return this.recipeRepository.getRecipesByName(name);
    }

    public List<Recipe> getRecipesByUserId() {
        return null;
    }

    public void removeRecipeById(UUID id) {
        this.recipeRepository.delete(this.getRecipeById(id));
    }
*/
    public void categoryExist(UUID id){
        this.getCategoryById(id);
    }

    private void saveCategory(Category category){
        this.categoryRepository.save(category);
    }
}
