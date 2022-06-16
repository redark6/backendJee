package fr.esgi.cookRecipe.Application.RecipeQueriesCommandsEvents.queries;

import fr.esgi.cookRecipe.Domain.User.Entity.UserAccount;
import fr.esgi.cookRecipe.Domain.User.Service.UserAccountService;
import fr.esgi.cookRecipe.Exposition.ProductDTO.NutriScoreDTO;
import fr.esgi.cookRecipe.Exposition.RecipeDTO.RecipeDTO;
import fr.esgi.cookRecipe.Exposition.RecipeDTO.RecipeProductDTO;
import fr.esgi.cookRecipe.Exposition.RecipeDTO.RecipeProductsDTO;
import fr.esgi.cookRecipe.Exposition.RecipeDTO.RecipesDTO;
import kernel.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;
import java.util.stream.Collectors;

public class RetrieveRecipesByUserIdHandler  implements QueryHandler<RetrieveRecipesByUserId, RecipesDTO> {

    private final UserAccountService userAccountService;

    @Autowired
    public RetrieveRecipesByUserIdHandler(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @Override
    public RecipesDTO handle(RetrieveRecipesByUserId query) {
        UUID userId = UUID.fromString(query.userId);
        UserAccount user = this.userAccountService.getUserById(userId);


        return RecipesDTO.of(
                user.getRecipies().stream().map(recipe ->
                        RecipeDTO.of(
                                recipe.getId().toString(),
                                recipe.getName(),
                                recipe.getShares(),
                                recipe.getExecutionTime(),
                                recipe.getPrice(),
                                RecipeProductsDTO.of(
                                        recipe.getProducts().stream().map(product ->
                                                RecipeProductDTO.of(
                                                        product.getProduct().getId().toString(),
                                                        product.getProduct().getName(),
                                                        product.getQuantity(),
                                                        product.getProduct().getMesure().getUnit(),
                                                        NutriScoreDTO.of(product.getProduct().getNutriScore().getId().toString(), product.getProduct().getNutriScore().getGrade())
                                                )
                                        ).collect(Collectors.toList())
                                )
                        )
                ).collect(Collectors.toList())
        );
    }
}
