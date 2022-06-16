package fr.esgi.cookRecipe.Application.ProductQueriesCommandsEvents.commands;

import fr.esgi.cookRecipe.Domain.Product.Entity.NutriScore;
import fr.esgi.cookRecipe.Domain.Product.Entity.Product;
import fr.esgi.cookRecipe.Domain.Product.Service.MeasureUniteService;
import fr.esgi.cookRecipe.Domain.Product.Service.NutriScoreService;
import fr.esgi.cookRecipe.Domain.Product.Service.ProductService;
import fr.esgi.cookRecipe.Domain.Util.Entity.MeasureUnit;
import kernel.CommandHandler;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class AddProductCommandHandler implements CommandHandler<AddProduct, Void> {

	private final ProductService productService;
	private final NutriScoreService nutriScoreService;
	private final MeasureUniteService measureUniteService;

	@Autowired
	public AddProductCommandHandler(ProductService productService, NutriScoreService nutriScoreService, MeasureUniteService measureUniteService) {
		this.productService = productService;
		this.nutriScoreService = nutriScoreService;
		this.measureUniteService = measureUniteService;
	}
    
    public Void handle(AddProduct command) {
		NutriScore nutriScore = this.nutriScoreService.getNutrisScoreById(UUID.fromString(command.addProductDTO.nutriScoreId));
		MeasureUnit measureUnit = this.measureUniteService.getMeasureUniteById(UUID.fromString(command.addProductDTO.uniteId));
		Product product = new Product();
		product.setId(null);
		product.setName(command.addProductDTO.name);
		product.setNutriScore(nutriScore);
		product.setMesure(measureUnit);
		this.productService.addProduct(product);
    	return null;
    }
}
