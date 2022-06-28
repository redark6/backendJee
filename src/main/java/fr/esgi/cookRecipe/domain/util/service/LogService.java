package fr.esgi.cookRecipe.domain.util.service;

import fr.esgi.cookRecipe.domain.product.entity.Product;
import fr.esgi.cookRecipe.domain.recipe.entity.Recipe;
import fr.esgi.cookRecipe.domain.util.entity.ProductLog;
import fr.esgi.cookRecipe.domain.util.entity.RecipeLog;
import fr.esgi.cookRecipe.domain.util.repository.ProductLogRepository;
import fr.esgi.cookRecipe.domain.util.repository.RecipeLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {

    private final ProductLogRepository productLogRepository;
    private final RecipeLogRepository recipeLogRepository;

    @Autowired
    public LogService(ProductLogRepository productLogRepository, RecipeLogRepository recipeLogRepository){
        this.productLogRepository = productLogRepository;
        this.recipeLogRepository = recipeLogRepository;
    }

    public ProductLog getProductLogByProduct(Product product){
        return this.productLogRepository.getProductLogByProduct(product);
    }

    public RecipeLog getRecipeLogByRecipe(Recipe recipe){
        return this.recipeLogRepository.getRecipeLogByRecipe(recipe);
    }

    public List<ProductLog> getMostResearchedProductLogByName(String name, Pageable pagination){
        Iterable<ProductLog> productLogs = this.productLogRepository.getProductLogByProduct_NameContainingOrderByCountDesc(name, pagination);
        return Streamable.of(productLogs).toList();
    }

    public List<RecipeLog> getMostResearchedRecipeLogByName(String name, Pageable pagination){
        Iterable<RecipeLog> recipeLogs = this.recipeLogRepository.getRecipeLogByRecipe_NameContainingOrderByCountDesc(name, pagination);
        return Streamable.of(recipeLogs).toList();
    }

    public List<ProductLog> getNeverResearchedProductLogByName(String name, Pageable pagination){
        Iterable<ProductLog> productLogs = this.productLogRepository.getProductLogByProduct_NameContainingAndCountLessThan(name, pagination, 1);
        return Streamable.of(productLogs).toList();
    }

    public List<RecipeLog> getNeverResearchedRecipeLogByName(String name, Pageable pagination){
        Iterable<RecipeLog> recipeLogs = this.recipeLogRepository.getRecipeLogByRecipe_NameContainingAndCountLessThan(name, pagination, 1);
        return Streamable.of(recipeLogs).toList();
    }

    public void saveProductLog(ProductLog productLog){
        this.productLogRepository.save(productLog);
    }

    public void saveRecipeLog(RecipeLog recipeLog){
        this.recipeLogRepository.save(recipeLog);
    }

}
