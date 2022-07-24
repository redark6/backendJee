package fr.esgi.cookRecipe.application.recipeQueriesCommandsEvents.queries;

import fr.esgi.cookRecipe.application.EntityToDTOSerializer;
import fr.esgi.cookRecipe.domain.recipe.entity.Recipe;
import fr.esgi.cookRecipe.domain.util.entity.RecipeLog;
import fr.esgi.cookRecipe.domain.util.service.LogService;
import fr.esgi.cookRecipe.exposition.RecipeDTO.RecipesDTO;
import fr.esgi.cookRecipe.external.service.RecipeApiService;
import kernel.QueryHandler;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;

public class RetrieveNeverResearchedRecipesByNameHandler implements QueryHandler<RetrieveNeverResearchedRecipesByName, RecipesDTO> {

    private final LogService logService;
    private final RecipeApiService recipeApiService;

    public RetrieveNeverResearchedRecipesByNameHandler(LogService logService, RecipeApiService recipeApiService) {
        this.logService = logService;
        this.recipeApiService = recipeApiService;
    }

    @Override
    public RecipesDTO handle(RetrieveNeverResearchedRecipesByName query) {
        Pageable pageRequest = PageRequest.of(query.offset, query.limit);
        String nameFound = query.autocomplete ? this.recipeApiService.getSearchAutocomplete(query.name) : query.name;
        List<RecipeLog> recipeLogs = this.logService.getNeverResearchedRecipeLogByName(nameFound,pageRequest);
        List<Recipe> recipes = recipeLogs.stream().map(r -> r.getRecipe()).collect(Collectors.toList());
        return EntityToDTOSerializer.recipeToRecipeDTO(recipes);
    }
}
