package fr.esgi.cookRecipe.application.recipeQueriesCommandsEvents.commands;

import fr.esgi.cookRecipe.domain.product.entity.Product;
import fr.esgi.cookRecipe.domain.product.service.ProductService;
import fr.esgi.cookRecipe.domain.recipe.entity.Recipe;
import fr.esgi.cookRecipe.domain.recipe.entity.RecipeProductQuantity;
import fr.esgi.cookRecipe.domain.recipe.service.RecipeService;
import fr.esgi.cookRecipe.domain.user.entity.UserAccount;
import fr.esgi.cookRecipe.domain.user.service.UserAccountService;
import fr.esgi.cookRecipe.domain.util.entity.RecipeLog;
import fr.esgi.cookRecipe.domain.util.entity.ResearchLog;
import fr.esgi.cookRecipe.domain.util.service.LogService;
import fr.esgi.cookRecipe.exposition.RecipeDTO.AddRecipeDTO;
import fr.esgi.cookRecipe.exposition.RecipeDTO.RecipeProductQuantityDTO;
import kernel.CommandHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class AddRecipeHandler implements CommandHandler<AddRecipe, Void> {

	private final ProductService productService;
	private final RecipeService recipeService;
	private final UserAccountService userAccountService;
	private final LogService logService;

	public AddRecipeHandler(ProductService productService, RecipeService recipeService, UserAccountService userAccountService, LogService logService) {
		this.productService = productService;
		this.recipeService = recipeService;
		this.userAccountService = userAccountService;
		this.logService = logService;
	}
    
    public Void handle(AddRecipe command) {
		UserAccount user = this.userAccountService.getMyUserAccount();
		AddRecipeDTO recipeDTO = command.addRecipeDTO;
		List<RecipeProductQuantity> products= recipeDTO.products.stream().map(product -> getProductItem(product)).collect(Collectors.toList());
		Recipe recipe = new Recipe();
		recipe.setName(recipeDTO.name);
		recipe.setShares(recipeDTO.shares);
		recipe.setExecutionTime(recipeDTO.executionTime);
		recipe.setPrice(recipeDTO.price);
		recipe.setProducts(products);
		recipe.setUser(user);
		Recipe recipeSaved = this.recipeService.addRecipe(recipe);
		RecipeLog recipeLog = new RecipeLog();
		recipeLog.setRecipe(recipeSaved);
		recipeLog.setCount(0);
		recipeLog.setResearches(new ArrayList<ResearchLog>());
		this.logService.saveRecipeLog(recipeLog);
		return null;
    }

	private RecipeProductQuantity getProductItem(RecipeProductQuantityDTO productQuantityDTO){
		Product product = this.productService.getProductById(UUID.fromString(productQuantityDTO.productId));
		RecipeProductQuantity RecipeProductQuantity = new RecipeProductQuantity();
		RecipeProductQuantity.setProduct(product);
		RecipeProductQuantity.setQuantity(productQuantityDTO.quantity);
		return RecipeProductQuantity;
	}
}
