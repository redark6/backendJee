package fr.esgi.cookRecipe.Application.ProductQueriesCommandsEvents.queries;

import fr.esgi.cookRecipe.Domain.Product.Entity.Product;
import fr.esgi.cookRecipe.Domain.Product.Service.ProductService;
import fr.esgi.cookRecipe.Exposition.ProductDTO.NutriScoreDTO;
import fr.esgi.cookRecipe.Exposition.ProductDTO.ProductDTO;
import kernel.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class RetrieveProductByIdHandler implements QueryHandler<RetrieveProductById, ProductDTO>{

    private final ProductService productService;

    @Autowired
    public RetrieveProductByIdHandler(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public ProductDTO handle(RetrieveProductById query) {
        UUID productId = UUID.fromString(query.productId);
        Product product = productService.getProductById(productId);
        return ProductDTO.of(
                product.getId().toString(),
                product.getName(),
                product.getMesure().getUnit(),
                NutriScoreDTO.of(
                        product.getNutriScore().getId().toString(),
                        product.getNutriScore().getGrade()
                )
        );
    }
}