package fr.esgi.cookRecipe.application.recipeQueriesCommandsEvents.queries;

import fr.esgi.cookRecipe.application.EntityToDTOSerializer;
import fr.esgi.cookRecipe.domain.recipe.entity.Recipe;
import fr.esgi.cookRecipe.domain.recipe.service.RecipeService;
import fr.esgi.cookRecipe.domain.user.service.UserAccountService;
import fr.esgi.cookRecipe.domain.util.entity.RecipeLog;
import fr.esgi.cookRecipe.domain.util.entity.ResearchLog;
import fr.esgi.cookRecipe.domain.util.service.LogService;
import fr.esgi.cookRecipe.exposition.RecipeDTO.RecipeDTO;
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
