package fr.esgi.cookRecipe.Application.RecipeQueriesCommandsEvents.queries;

import fr.esgi.cookRecipe.Application.EntityToDTOSerializer;
import fr.esgi.cookRecipe.Domain.Recipe.Entity.Recipe;
import fr.esgi.cookRecipe.Domain.Util.Entity.RecipeLog;
import fr.esgi.cookRecipe.Domain.Util.Service.LogService;
import fr.esgi.cookRecipe.Exposition.RecipeDTO.RecipesDTO;
import kernel.QueryHandler;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;

public class RetrieveNeverResearchedRecipesByNameHandler implements QueryHandler<RetrieveNeverResearchedRecipesByName, RecipesDTO> {

    private final LogService logService;

    public RetrieveNeverResearchedRecipesByNameHandler(LogService logService) {
        this.logService = logService;
    }

    @Override
    public RecipesDTO handle(RetrieveNeverResearchedRecipesByName query) {
        Pageable pageRequest = PageRequest.of(query.offset, query.limit);
        // service pour deduire le name
        List<RecipeLog> recipeLogs = this.logService.getNeverResearchedRecipeLogByName(query.name,pageRequest);
        List<Recipe> recipes = recipeLogs.stream().map(r -> r.getRecipe()).collect(Collectors.toList());
        return EntityToDTOSerializer.recipeToRecipeDTO(recipes);
    }
}
