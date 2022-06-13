package fr.esgi.cookRecipe.Application.RecipeQueriesCommandsEvents.queries;

import fr.esgi.cookRecipe.Domain.Product.Entity.Product;
import fr.esgi.cookRecipe.Domain.Product.Service.ProductService;
import fr.esgi.cookRecipe.Exposition.ProductDTO.NutriScoreDTO;
import fr.esgi.cookRecipe.Exposition.ProductDTO.ProductDTO;
import kernel.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;

public class RetrievePaginatedRecipesHandler implements QueryHandler<RetrievePaginatedRecipes, ProductDTO> {

    private final ProductService productService;

    @Autowired
    public RetrievePaginatedRecipesHandler(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public ProductDTO handle(RetrievePaginatedRecipes query) {
        Product product = productService.getProductByName(query.productName);
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