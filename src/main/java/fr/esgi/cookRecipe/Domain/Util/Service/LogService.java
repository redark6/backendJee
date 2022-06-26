package fr.esgi.cookRecipe.Domain.Util.Service;

import fr.esgi.cookRecipe.Domain.Util.Repository.ProductLogRepository;
import fr.esgi.cookRecipe.Domain.Util.Repository.RecipeLogRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class LogService {

    private final ProductLogRepository productLogRepository;
    private final RecipeLogRepository recipeLogRepository;

    @Autowired
    public LogService(ProductLogRepository productLogRepository, RecipeLogRepository recipeLogRepository){
        this.productLogRepository = productLogRepository;
        this.recipeLogRepository = recipeLogRepository;
    }

    public void addRecipeLog(){
        this.recipeLogRepository.save();
    }

    public void addProductLog(){
        this.productLogRepository.save();
    }
}
