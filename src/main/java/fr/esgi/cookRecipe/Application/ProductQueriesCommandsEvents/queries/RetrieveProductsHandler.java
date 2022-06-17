package fr.esgi.cookRecipe.Application.ProductQueriesCommandsEvents.queries;

import fr.esgi.cookRecipe.Application.EntityToDTOSerializer;
import fr.esgi.cookRecipe.Domain.Product.Entity.Product;
import fr.esgi.cookRecipe.Domain.Product.Service.ProductService;
import fr.esgi.cookRecipe.Exposition.ProductDTO.ProductsDTO;
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
