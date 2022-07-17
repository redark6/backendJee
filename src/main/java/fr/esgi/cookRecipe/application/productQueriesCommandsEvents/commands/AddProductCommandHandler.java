package fr.esgi.cookRecipe.application.productQueriesCommandsEvents.commands;

import fr.esgi.cookRecipe.domain.product.entity.NutriScore;
import fr.esgi.cookRecipe.domain.product.entity.Product;
import fr.esgi.cookRecipe.domain.util.entity.ProductLog;
import fr.esgi.cookRecipe.domain.util.entity.ResearchLog;
import fr.esgi.cookRecipe.domain.util.service.LogService;
import fr.esgi.cookRecipe.domain.util.service.MeasureUniteService;
import fr.esgi.cookRecipe.domain.product.service.NutriScoreService;
import fr.esgi.cookRecipe.domain.product.service.ProductService;
import fr.esgi.cookRecipe.domain.util.entity.MeasureUnit;
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
		product.setMeasure(measureUnit);
		Product productSaved = this.productService.addProduct(product);
		ProductLog productLog = new ProductLog();
		productLog.setProduct(productSaved);
		productLog.setCount(0);
		productLog.setResearches(new ArrayList<ResearchLog>());
		this.logService.saveProductLog(productLog);
    	return null;
    }
}
