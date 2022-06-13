package fr.esgi.cookRecipe.Application.ProductQueriesCommandsEvents.queries;

import fr.esgi.cookRecipe.Domain.Product.Entity.Product;
import fr.esgi.cookRecipe.Domain.Product.Service.ProductService;
import fr.esgi.cookRecipe.Exposition.ProductDTO.NutriScoreDTO;
import fr.esgi.cookRecipe.Exposition.ProductDTO.ProductDTO;
import fr.esgi.cookRecipe.Exposition.ProductDTO.ProductsDTO;
import kernel.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class RetrieveProductsHandler implements QueryHandler<RetrieveProducts, ProductsDTO> {

	private final ProductService productService;

	@Autowired
	public RetrieveProductsHandler(ProductService productService) {
		this.productService = productService;
	}

	@Override
	public ProductsDTO handle(RetrieveProducts query) {
		List<Product> products = productService.getAllProducts();

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
