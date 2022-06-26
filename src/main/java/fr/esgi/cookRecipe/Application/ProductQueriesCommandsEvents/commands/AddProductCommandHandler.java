package fr.esgi.cookRecipe.Application.ProductQueriesCommandsEvents.commands;

import fr.esgi.cookRecipe.Domain.Product.Entity.NutriScore;
import fr.esgi.cookRecipe.Domain.Product.Entity.Product;
import fr.esgi.cookRecipe.Domain.Util.Entity.ProductLog;
import fr.esgi.cookRecipe.Domain.Util.Entity.ResearchLog;
import fr.esgi.cookRecipe.Domain.Util.Service.LogService;
import fr.esgi.cookRecipe.Domain.Util.Service.MeasureUniteService;
import fr.esgi.cookRecipe.Domain.Product.Service.NutriScoreService;
import fr.esgi.cookRecipe.Domain.Product.Service.ProductService;
import fr.esgi.cookRecipe.Domain.Util.Entity.MeasureUnit;
import kernel.CommandHandler;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.UUID;

public class AddProductCommandHandler implements CommandHandler<AddProduct, Void> {

	private final ProductService productService;
	private final NutriScoreService nutriScoreService;
	private final MeasureUniteService measureUniteService;
	private final LogService logService;

	@Autowired
	public AddProductCommandHandler(ProductService productService, NutriScoreService nutriScoreService, MeasureUniteService measureUniteService, LogService logService) {
		this.productService = productService;
		this.nutriScoreService = nutriScoreService;
		this.measureUniteService = measureUniteService;
		this.logService = logService;
	}
    
    public Void handle(AddProduct command) {
		NutriScore nutriScore = this.nutriScoreService.getNutrisScoreById(UUID.fromString(command.addProductDTO.nutriScoreId));
		MeasureUnit measureUnit = this.measureUniteService.getMeasureUniteById(UUID.fromString(command.addProductDTO.uniteId));
		Product product = new Product();
		product.setName(command.addProductDTO.name);
		product.setNutriScore(nutriScore);
		product.setMesure(measureUnit);
		Product productSaved = this.productService.addProduct(product);
		ProductLog productLog = new ProductLog();
		productLog.setProduct(productSaved);
		productLog.setCount(0);
		productLog.setResearches(new ArrayList<ResearchLog>());
		this.logService.saveProductLog(productLog);
    	return null;
    }
}
