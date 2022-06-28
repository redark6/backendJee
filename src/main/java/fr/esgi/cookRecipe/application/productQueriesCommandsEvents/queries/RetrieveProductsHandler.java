package fr.esgi.cookRecipe.application.productQueriesCommandsEvents.queries;

import fr.esgi.cookRecipe.application.EntityToDTOSerializer;
import fr.esgi.cookRecipe.domain.product.entity.Product;
import fr.esgi.cookRecipe.domain.product.service.ProductService;
import fr.esgi.cookRecipe.exposition.ProductDTO.ProductsDTO;
import kernel.QueryHandler;

import java.util.List;

public class RetrieveProductsHandler implements QueryHandler<RetrieveProducts, ProductsDTO> {

	private final ProductService productService;

	public RetrieveProductsHandler(ProductService productService) {
		this.productService = productService;
	}

	@Override
	public ProductsDTO handle(RetrieveProducts query) {
		List<Product> products = productService.getAllProducts();
		return EntityToDTOSerializer.productsToProductsDTO(products);
	}
}
