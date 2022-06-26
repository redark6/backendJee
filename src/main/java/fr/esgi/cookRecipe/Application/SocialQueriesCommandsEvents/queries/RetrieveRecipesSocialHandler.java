package fr.esgi.cookRecipe.Application.SocialQueriesCommandsEvents.queries;

import fr.esgi.cookRecipe.Application.EntityToDTOSerializer;
import fr.esgi.cookRecipe.Domain.Recipe.Entity.Recipe;
import fr.esgi.cookRecipe.Domain.Recipe.Service.RecipeService;
import fr.esgi.cookRecipe.Domain.Social.Entity.Category;
import fr.esgi.cookRecipe.Domain.Social.Entity.Comment;
import fr.esgi.cookRecipe.Domain.Social.Entity.Like;
import fr.esgi.cookRecipe.Domain.Social.Entity.Rate;
import fr.esgi.cookRecipe.Domain.Social.Service.CategoryService;
import fr.esgi.cookRecipe.Domain.Social.Service.CommentService;
import fr.esgi.cookRecipe.Domain.Social.Service.LikeService;
import fr.esgi.cookRecipe.Domain.Social.Service.RateService;
import fr.esgi.cookRecipe.Domain.User.Entity.UserAccount;
import fr.esgi.cookRecipe.Domain.User.Service.UserAccountService;
import fr.esgi.cookRecipe.Exposition.SocialDTO.CommentsDTO;
import fr.esgi.cookRecipe.Exposition.SocialDTO.LikeDTO;
import fr.esgi.cookRecipe.Exposition.SocialDTO.RatingsUserDTO;
import fr.esgi.cookRecipe.Exposition.SocialDTO.RecipeSocialDTO;
import kernel.QueryHandler;

import java.util.*;

public class RetrieveRecipesSocialHandler implements QueryHandler<RetrieveRecipesSocial, RecipeSocialDTO> {

    private final RateService rateService;
    private final CategoryService categoryService;
    private final RecipeService recipeService;
    private final CommentService commentService;
    private final LikeService likeService;
    private final UserAccountService userAccountService;

    public RetrieveRecipesSocialHandler(RateService rateService, CategoryService categoryService, RecipeService recipeService, CommentService commentService, LikeService likeService, UserAccountService userAccountService) {
        this.rateService = rateService;
        this.categoryService = categoryService;
        this.recipeService = recipeService;
        this.commentService = commentService;
        this.likeService = likeService;
        this.userAccountService = userAccountService;
    }

    @Override
    public RecipeSocialDTO handle(RetrieveRecipesSocial query) {
        UserAccount user = this.userAccountService.getMyUserAccount();

        Recipe recipe = this.recipeService.getRecipeById(UUID.fromString(query.recipeId));
        List<Category> categories = this.categoryService.getAllCategories();
        List<Comment> comments = this.commentService.getCommentsByRecipe(recipe);

        Map<Category, List<Rate>> categoryRatesMap = new HashMap<Category, List<Rate>>();
        categories.forEach(category -> {
            List<Rate> rates = this.rateService.getRecipeCategoryRates(recipe, category);
            categoryRatesMap.put(category,rates);
        });

        long likeNumber = this.likeService.getRecipeLikeScore(recipe);
        Optional<Like> userLike = this.likeService.findUserRecipeLike(recipe,user);

        CommentsDTO commentsDTO = EntityToDTOSerializer.commentsToCommentsDTO(comments, user.getId().toString());
        RatingsUserDTO ratingDTO = EntityToDTOSerializer.ratingMapCategoryRatesTORatingsDTO(categoryRatesMap, user.getId().toString());
        LikeDTO likeDTO = LikeDTO.of(likeNumber, userLike.isPresent() ? userLike.get().isLiked() : false);

        return RecipeSocialDTO.of(commentsDTO, likeDTO, ratingDTO);
    }


}
