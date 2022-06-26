package fr.esgi.cookRecipe.Application.SocialQueriesCommandsEvents.commands;

import fr.esgi.cookRecipe.Domain.Recipe.Entity.Recipe;
import fr.esgi.cookRecipe.Domain.Recipe.Service.RecipeService;
import fr.esgi.cookRecipe.Domain.Social.Entity.Like;
import fr.esgi.cookRecipe.Domain.Social.Service.LikeService;
import fr.esgi.cookRecipe.Domain.User.Entity.UserAccount;
import fr.esgi.cookRecipe.Domain.User.Service.UserAccountService;
import kernel.CommandHandler;

import java.util.Optional;
import java.util.UUID;

public class LikeRecipeHandler implements CommandHandler<LikeRecipe, Void> {

    private final LikeService likeService;
    private final RecipeService recipeService;
    private final UserAccountService userAccountService;

    public LikeRecipeHandler(LikeService likeService, RecipeService recipeService, UserAccountService userAccountService) {
        this.likeService = likeService;
        this.recipeService = recipeService;
        this.userAccountService = userAccountService;
    }

    public Void handle(LikeRecipe command) {
        Recipe recipe = this.recipeService.getRecipeById(UUID.fromString(command.recipeId));
        UserAccount user = this.userAccountService.getMyUserAccount();
        Optional<Like> userLikesRecipeMaybe = this.likeService.findUserRecipeLike(recipe,user);
        Like userLikesRecipe;
        if(userLikesRecipeMaybe.isPresent()){
            userLikesRecipe = userLikesRecipeMaybe.get();
        }else{
            userLikesRecipe = new Like();
            userLikesRecipe.setId(UUID.randomUUID());
            userLikesRecipe.setRecipe(recipe);
            userLikesRecipe.setUser(user);
        }
        userLikesRecipe.setLiked(command.liked);
        this.likeService.putlikeRecipe(userLikesRecipe);
        return null;
    }
}
