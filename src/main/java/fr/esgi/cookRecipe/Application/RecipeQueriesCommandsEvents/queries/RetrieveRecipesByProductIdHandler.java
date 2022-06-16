package fr.esgi.cookRecipe.Application.RecipeQueriesCommandsEvents.queries;

import fr.esgi.cookRecipe.Domain.Product.Entity.Product;
import fr.esgi.cookRecipe.Domain.Product.Service.ProductService;
import fr.esgi.cookRecipe.Domain.Recipe.Entity.Recipe;
import fr.esgi.cookRecipe.Domain.Recipe.Service.RecipeService;
import fr.esgi.cookRecipe.Exposition.ProductDTO.NutriScoreDTO;
import fr.esgi.cookRecipe.Exposition.ProductDTO.ProductDTO;
import fr.esgi.cookRecipe.Exposition.ProductDTO.ProductsDTO;
import fr.esgi.cookRecipe.Exposition.RecipeDTO.RecipeDTO;
import fr.esgi.cookRecipe.Exposition.RecipeDTO.RecipeProductDTO;
import fr.esgi.cookRecipe.Exposition.RecipeDTO.RecipeProductsDTO;
import fr.esgi.cookRecipe.Exposition.RecipeDTO.RecipesDTO;
import kernel.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;

public class RetrieveRecipesByProductIdHandler implements QueryHandler<RetrieveRecipesByProductId, RecipesDTO> {

    private final RecipeService recipeService;

    @Autowired
    public RetrieveRecipesByProductIdHandler(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @Override
    public RecipesDTO handle(RetrieveRecipesByProductId query) {
        Pageable pageRequest = PageRequest.of(query.offset, query.limit);

        List<Recipe> recipes = this.recipeService.getRecipesByName(query.productId); // -> create query for product id

        return RecipesDTO.of(
                recipes.stream().map(recipe ->
                        RecipeDTO.of(
                                recipe.getId().toString(),
                                recipe.getName(),
                                recipe.getShares(),
                                recipe.getExecutionTime(),
                                recipe.getPrice(),
                                RecipeProductsDTO.of(
                                        recipe.getProducts().stream().map(product ->
                                                RecipeProductDTO.of(
                                                        product.getProduct().getId().toString(),
                                                        product.getProduct().getName(),
                                                        product.getQuantity(),
                                                        product.getProduct().getMesure().getUnit(),
                                                        NutriScoreDTO.of(product.getProduct().getNutriScore().getId().toString(), product.getProduct().getNutriScore().getGrade())
                                                )
                                        ).collect(Collectors.toList())
                                )
                        )
                ).collect(Collectors.toList())
        );
    }
}
