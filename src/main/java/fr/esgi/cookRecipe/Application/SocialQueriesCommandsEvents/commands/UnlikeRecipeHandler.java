package fr.esgi.cookRecipe.Application.SocialQueriesCommandsEvents.commands;

import fr.esgi.cookRecipe.Domain.Recipe.Service.RecipeService;
import fr.esgi.cookRecipe.Domain.Social.Entity.UserLikesRecipe;
import fr.esgi.cookRecipe.Domain.Social.Service.LikeService;
import kernel.CommandHandler;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;
import java.util.UUID;

public class UnlikeRecipeHandler implements CommandHandler<UnlikeRecipe, Void> {

    private final LikeService likeService;
    private final RecipeService recipeService;

    public UnlikeRecipeHandler(LikeService likeService, RecipeService recipeService) {
        this.likeService = likeService;
        this.recipeService = recipeService;
    }

    public Void handle(UnlikeRecipe command) {
        UUID recipeId = UUID.fromString(command.recipeId);
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        this.recipeService.recipeExist(recipeId);
        Optional<UserLikesRecipe> userLikesRecipeMaybe = this.likeService.findUserRecipeLike(recipeId,userId);
        UserLikesRecipe userLikesRecipe;
        if(userLikesRecipeMaybe.isPresent()){
            userLikesRecipe = userLikesRecipeMaybe.get();
        }else{
            userLikesRecipe = new UserLikesRecipe();
            userLikesRecipe.setId(UUID.randomUUID());
            userLikesRecipe.setRecipeId(recipeId);
            userLikesRecipe.setUserId(userId);
        }
        userLikesRecipe.setLiked(false);
        this.likeService.putlikeRecipe(userLikesRecipe);
        return null;
    }
}
