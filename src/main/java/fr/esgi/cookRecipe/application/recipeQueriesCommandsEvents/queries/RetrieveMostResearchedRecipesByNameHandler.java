package fr.esgi.cookRecipe.application.recipeQueriesCommandsEvents.queries;

import fr.esgi.cookRecipe.application.EntityToDTOSerializer;
import fr.esgi.cookRecipe.domain.recipe.entity.Recipe;
import fr.esgi.cookRecipe.domain.util.entity.RecipeLog;
import fr.esgi.cookRecipe.domain.util.service.LogService;
import fr.esgi.cookRecipe.exposition.RecipeDTO.RecipesDTO;
import kernel.QueryHandler;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;

public class RetrieveMostResearchedRecipesByNameHandler implements QueryHandler<RetrieveMostResearchedRecipesByName, RecipesDTO> {

    private final LogService logService;

    public RetrieveMostResearchedRecipesByNameHandler(LogService logService) {
        this.logService = logService;
    }

    @Override
    public RecipesDTO handle(RetrieveMostResearchedRecipesByName query) {
        Pageable pageRequest = PageRequest.of(query.offset, query.limit);
        // service pour deduire le name
        List<RecipeLog> recipeLogs = this.logService.getMostResearchedRecipeLogByName(query.name,pageRequest);
        List<Recipe> recipes = recipeLogs.stream().map(r -> r.getRecipe()).collect(Collectors.toList());
        return EntityToDTOSerializer.recipeToRecipeDTO(recipes);
    }
}
