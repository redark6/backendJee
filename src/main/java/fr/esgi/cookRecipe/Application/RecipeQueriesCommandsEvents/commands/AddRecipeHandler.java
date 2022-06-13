package fr.esgi.cookRecipe.Application.RecipeQueriesCommandsEvents.commands;

import fr.esgi.cookRecipe.Application.RecipeQueriesCommandsEvents.events.AddProductEvent;
import fr.esgi.cookRecipe.Domain.Product.Entity.NutriScore;
import fr.esgi.cookRecipe.Domain.Product.Entity.Product;
import fr.esgi.cookRecipe.Domain.Product.Service.NutriScoreService;
import fr.esgi.cookRecipe.Domain.Product.Service.ProductService;
import fr.esgi.cookRecipe.Domain.Util.Entity.MeasureUnit;
import kernel.CommandHandler;
import kernel.Event;
import kernel.EventDispatcher;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class AddRecipeHandler implements CommandHandler<AddRecipe, Void> {

	private final ProductService productService;
	private final NutriScoreService nutriScoreService;
	private final MeseaureUniteService meseaureUniteService;
	private final EventDispatcher<Event> eventDispatcher;

	@Autowired
	public AddRecipeHandler(ProductService productService, NutriScoreService nutriScoreService, MeseaureUniteService meseaureUniteService, EventDispatcher eventDispatcher) {
		this.productService = productService;
		this.nutriScoreService = nutriScoreService;
		this.meseaureUniteService = meseaureUniteService;
		this.eventDispatcher = eventDispatcher;
	}
    
    public Void handle(AddRecipe command) {
		NutriScore nutriScore = this.nutriScoreService.getNutrisScoreById(UUID.fromString(command.addProductDTO.nutriScoreId));
		MeasureUnit measureUnit = this.meseaureUniteService.getMeasureUniteById(UUID.fromString(command.addProductDTO.uniteId));
		Product product = new Product();
		product.setId(null);
		product.setName(command.addProductDTO.name);
		product.setNutriScore(nutriScore);
		product.setMesure(measureUnit);
		this.productService.addProduct(product);
    	eventDispatcher.dispatch(AddProductEvent.of(nutriScore.getGrade()));
    	return null;
    }
}
