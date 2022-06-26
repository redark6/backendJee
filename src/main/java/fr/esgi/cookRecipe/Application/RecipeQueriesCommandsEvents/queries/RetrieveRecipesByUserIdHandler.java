package fr.esgi.cookRecipe.Application.RecipeQueriesCommandsEvents.queries;

import fr.esgi.cookRecipe.Application.EntityToDTOSerializer;
import fr.esgi.cookRecipe.Domain.Recipe.Entity.Recipe;
import fr.esgi.cookRecipe.Domain.Recipe.Service.RecipeService;
import fr.esgi.cookRecipe.Domain.User.Entity.UserAccount;
import fr.esgi.cookRecipe.Domain.User.Service.UserAccountService;
import fr.esgi.cookRecipe.Exposition.RecipeDTO.RecipesDTO;
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
