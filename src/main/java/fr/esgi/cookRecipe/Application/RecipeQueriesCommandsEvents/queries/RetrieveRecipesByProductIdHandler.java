package fr.esgi.cookRecipe.Application.RecipeQueriesCommandsEvents.queries;

import fr.esgi.cookRecipe.Domain.Product.Entity.Product;
import fr.esgi.cookRecipe.Domain.Product.Service.ProductService;
import fr.esgi.cookRecipe.Exposition.ProductDTO.NutriScoreDTO;
import fr.esgi.cookRecipe.Exposition.ProductDTO.ProductDTO;
import fr.esgi.cookRecipe.Exposition.ProductDTO.ProductsDTO;
import kernel.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;

public class RetrieveRecipesByProductIdHandler implements QueryHandler<RetrieveRecipesByProductId, ProductsDTO> {

    private final ProductService productService;

    @Autowired
    public RetrieveRecipesByProductIdHandler(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public ProductsDTO handle(RetrieveRecipesByProductId query) {
        Pageable pageRequest = PageRequest.of(query.offset, query.limit);
        List<Product> products = productService.getPaginatedProductList(pageRequest);

        ProductsDTO result = ProductsDTO.of(products.stream()
                .map(product ->
                        ProductDTO.of(
                                product.getId().toString(),
                                product.getName(),
                                product.getMesure().getUnit(),
                                NutriScoreDTO.of(
                                        product.getNutriScore().getId().toString(),
                                        product.getNutriScore().getGrade()
                                )
                        )
                ).collect(Collectors.toList()));
        return result;
    }
}
