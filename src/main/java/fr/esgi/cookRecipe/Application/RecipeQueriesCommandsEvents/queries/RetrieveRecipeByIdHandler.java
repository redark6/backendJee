package fr.esgi.cookRecipe.Application.RecipeQueriesCommandsEvents.queries;

import fr.esgi.cookRecipe.Application.EntityToDTOSerializer;
import fr.esgi.cookRecipe.Domain.Recipe.Entity.Recipe;
import fr.esgi.cookRecipe.Domain.Recipe.Service.RecipeService;
import fr.esgi.cookRecipe.Domain.User.Service.UserAccountService;
import fr.esgi.cookRecipe.Domain.Util.Entity.RecipeLog;
import fr.esgi.cookRecipe.Domain.Util.Entity.ResearchLog;
import fr.esgi.cookRecipe.Domain.Util.Service.LogService;
import fr.esgi.cookRecipe.Exposition.RecipeDTO.RecipeDTO;
import kernel.QueryHandler;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class RetrieveRecipeByIdHandler implements QueryHandler<RetrieveRecipeById, RecipeDTO> {

	private final RecipeService recipeService;
	private final LogService logService;
	private final UserAccountService userAccountService;

	public RetrieveRecipeByIdHandler(RecipeService recipeService, LogService logService, UserAccountService userAccountService) {
		this.recipeService = recipeService;
		this.logService = logService;
		this.userAccountService = userAccountService;
	}

	@Override
	public RecipeDTO handle(RetrieveRecipeById query) {
		UUID recipeId = UUID.fromString(query.recipeId);
		Recipe recipe = recipeService.getRecipeById(recipeId);
		RecipeLog recipeLog = this.logService.getRecipeLogByRecipe(recipe);
		List<ResearchLog> researchLogList = recipeLog.getResearches();
		ResearchLog researchLog = new ResearchLog();
		researchLog.setUser(this.userAccountService.getMyUserAccount());
		researchLog.setEntitled(query.research);
		researchLog.setExecutionDate(new Date());
		researchLogList.add(researchLog);
		recipeLog.setResearches(researchLogList);
		recipeLog.setCount(recipeLog.getCount() + 1);
		this.logService.saveRecipeLog(recipeLog);
		return EntityToDTOSerializer.recipeToRecipeDTO(recipe);
	}
}
