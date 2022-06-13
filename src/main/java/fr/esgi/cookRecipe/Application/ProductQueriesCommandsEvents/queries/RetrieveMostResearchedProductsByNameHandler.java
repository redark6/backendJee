package fr.esgi.cookRecipe.Application.ProductQueriesCommandsEvents.queries;

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

public class RetrieveMostResearchedProductsByNameHandler implements QueryHandler<RetrieveMostResearchedProductsByName, ProductsDTO> {
    private final ProductService productService;

    @Autowired
    public RetrieveMostResearchedProductsByNameHandler(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public ProductsDTO handle(RetrieveMostResearchedProductsByName query) {
        Pageable pageRequest = PageRequest.of(query.offset, query.limit);
        List<Product> products = productService.getProductsByName(query.productName, pageRequest); // // remplacer par un get most researched
        return ProductsDTO.of(products.stream()
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
                ).collect(Collectors.toList())
        );
    }
}
