package fr.esgi.cookRecipe.Application.SocialQueriesCommandsEvents.queries;

import fr.esgi.cookRecipe.Domain.Recipe.Service.RecipeService;
import fr.esgi.cookRecipe.Domain.Social.Service.CategoryService;
import fr.esgi.cookRecipe.Domain.Social.Service.CommentService;
import fr.esgi.cookRecipe.Domain.Social.Service.RateService;
import fr.esgi.cookRecipe.Domain.Social.Service.UserCommentRecipeService;
import fr.esgi.cookRecipe.Exposition.SocialDTO.CommentsDTO;
import fr.esgi.cookRecipe.Exposition.SocialDTO.LikeDTO;
import fr.esgi.cookRecipe.Exposition.SocialDTO.RatingsUserDTO;
import fr.esgi.cookRecipe.Exposition.SocialDTO.RecipeSocialDTO;
import kernel.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.UUID;

public class RetrieveRecipesSocialHandler implements QueryHandler<RetrieveRecipesSocial, RecipeSocialDTO> {

    private final RateService rateService;
    private final CategoryService categoryService;
    private final RecipeService recipeService;
    private final CommentService commentService;
    private final UserCommentRecipeService userCommentRecipeService;

    @Autowired
    public RetrieveRecipesSocialHandler(RateService rateService, CategoryService categoryService, RecipeService recipeService, CommentService commentService, UserCommentRecipeService userCommentRecipeService) {
        this.rateService = rateService;
        this.categoryService = categoryService;
        this.recipeService = recipeService;
        this.commentService = commentService;
        this.userCommentRecipeService = userCommentRecipeService;
    }

    @Override
    public RecipeSocialDTO handle(RetrieveRecipesSocial query) {
        UUID recipeId = UUID.fromString(query.recipeId);
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        this.recipeService.recipeExist(recipeId);
        this.categoryService.getAllCategories();

        this.userCommentRecipeService.()

         CommentsDTO comments;
         LikeDTO like;
         RatingsUserDTO ratings;


        return RecipeSocialDTO.of(comments, like, RatingsUserDTO);
    }


}
