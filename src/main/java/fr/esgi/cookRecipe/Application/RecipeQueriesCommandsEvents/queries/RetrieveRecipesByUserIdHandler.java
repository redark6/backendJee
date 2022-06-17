package fr.esgi.cookRecipe.Application.RecipeQueriesCommandsEvents.queries;

import fr.esgi.cookRecipe.Application.EntityToDTOSerializer;
import fr.esgi.cookRecipe.Domain.User.Entity.UserAccount;
import fr.esgi.cookRecipe.Domain.User.Service.UserAccountService;
import fr.esgi.cookRecipe.Exposition.RecipeDTO.RecipesDTO;
import kernel.QueryHandler;

import java.util.UUID;

public class RetrieveRecipesByUserIdHandler  implements QueryHandler<RetrieveRecipesByUserId, RecipesDTO> {

    private final UserAccountService userAccountService;

    public RetrieveRecipesByUserIdHandler(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @Override
    public RecipesDTO handle(RetrieveRecipesByUserId query) {
        UUID userId = UUID.fromString(query.userId);
        UserAccount user = this.userAccountService.getUserById(userId);
        return EntityToDTOSerializer.recipeToRecipeDTO(user.getRecipies());
    }
}
