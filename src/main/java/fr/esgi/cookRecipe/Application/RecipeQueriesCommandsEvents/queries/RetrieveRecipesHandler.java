package fr.esgi.cookRecipe.Application.RecipeQueriesCommandsEvents.queries;

import fr.esgi.cookRecipe.Domain.Product.Entity.Product;
import fr.esgi.cookRecipe.Domain.Product.Service.ProductService;
import fr.esgi.cookRecipe.Domain.Recipe.Entity.Recipe;
import fr.esgi.cookRecipe.Domain.Recipe.Service.RecipeService;
import fr.esgi.cookRecipe.Exposition.ProductDTO.NutriScoreDTO;
import fr.esgi.cookRecipe.Exposition.ProductDTO.ProductDTO;
import fr.esgi.cookRecipe.Exposition.RecipeDTO.RecipesDTO;
import kernel.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class RetrieveRecipesHandler implements QueryHandler<RetrieveRecipes, RecipesDTO>{

    private final RecipeService recipeService;

    @Autowired
    public RetrieveRecipesHandler(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @Override
    public RecipesDTO handle(RetrieveRecipes query) {
    	List<Recipe> recipes = recipeService.getAllRecipes();

        ProductDTO result = ProductDTO.of(
                product.getId().toString(),
                product.getName(),
                product.getMesure().getUnit(),
                NutriScoreDTO.of(
                        product.getNutriScore().getId().toString(),
                        product.getNutriScore().getGrade()
                        )
                );
        return result;
    }
}