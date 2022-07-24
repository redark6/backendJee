package fr.esgi.cookRecipe.application.recipeQueriesCommandsEvents.queries;

import fr.esgi.cookRecipe.application.EntityToDTOSerializer;
import fr.esgi.cookRecipe.domain.recipe.entity.Recipe;
import fr.esgi.cookRecipe.domain.recipe.service.RecipeService;
import fr.esgi.cookRecipe.domain.user.entity.UserAccount;
import fr.esgi.cookRecipe.domain.user.service.UserAccountService;
import fr.esgi.cookRecipe.exposition.RecipeDTO.RecipesDTO;
import kernel.QueryHandler;

import java.util.List;
import java.util.UUID;

public class RetrieveRecipesByUserIdHandler  implements QueryHandler<RetrieveRecipesByUserId, RecipesDTO> {

    private final UserAccountService userAccountService;
    private final RecipeService recipeService;

    public RetrieveRecipesByUserIdHandler(UserAccountService userAccountService, RecipeService recipeService) {
        this.userAccountService = userAccountService;
        this.recipeService = recipeService;
    }

    @Override
    public RecipesDTO handle(RetrieveRecipesByUserId query) {
        UUID userId = UUID.fromString(query.userId);
        UserAccount user = this.userAccountService.getUserById(userId);
        List<Recipe> recipes = this.recipeService.getRecipesByUser(user);
        return EntityToDTOSerializer.recipeToRecipeDTO(recipes);
    }
}
