package fr.esgi.cookRecipe.application;

import fr.esgi.cookRecipe.domain.product.entity.NutriScore;
import fr.esgi.cookRecipe.domain.product.entity.Product;
import fr.esgi.cookRecipe.domain.recipe.entity.Recipe;
import fr.esgi.cookRecipe.domain.social.entity.Category;
import fr.esgi.cookRecipe.domain.social.entity.Comment;
import fr.esgi.cookRecipe.domain.social.entity.Rate;
import fr.esgi.cookRecipe.domain.user.entity.UserAccount;
import fr.esgi.cookRecipe.domain.util.entity.MeasureUnit;
import fr.esgi.cookRecipe.exposition.ProductDTO.*;
import fr.esgi.cookRecipe.exposition.RecipeDTO.RecipeDTO;
import fr.esgi.cookRecipe.exposition.RecipeDTO.RecipeProductDTO;
import fr.esgi.cookRecipe.exposition.RecipeDTO.RecipeProductsDTO;
import fr.esgi.cookRecipe.exposition.RecipeDTO.RecipesDTO;
import fr.esgi.cookRecipe.exposition.SocialDTO.*;
import fr.esgi.cookRecipe.exposition.UserDTO.UserDTO;
import fr.esgi.cookRecipe.exposition.UserDTO.UserListItemDTO;
import fr.esgi.cookRecipe.exposition.UserDTO.UserMeDTO;
import fr.esgi.cookRecipe.exposition.UserDTO.UsersDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class EntityToDTOSerializer {

    public static ProductDTO productToProductDTO(Product product){
        return ProductDTO.of(
                product.getId().toString(),
                product.getName(),
                product.getMeasure().getUnit(),
                NutriScoreDTO.of(
                        product.getNutriScore().getId().toString(),
                        product.getNutriScore().getGrade()
                )
        );
    }

    public static ProductsDTO productsToProductsDTO(List<Product> products){
        return ProductsDTO.of(products.stream().map(
                product -> productToProductDTO(product)
        ).collect(Collectors.toList()));
    }

    public static NutriScoreDTO nutriscoreToNutriScoreDTO(NutriScore nutriScore){
        return NutriScoreDTO.of(
                nutriScore.getId().toString(),
                nutriScore.getGrade()
        );
    }

    public static NutriScoresDTO nutriscoresToNutriScoresDTO(List<NutriScore> nutriScores){
        return NutriScoresDTO.of(nutriScores.stream().map(
                nutriScore -> nutriscoreToNutriScoreDTO(nutriScore)
        ).collect(Collectors.toList()));
    }


    public static RecipeDTO recipeToRecipeDTO(Recipe recipe) {
        return RecipeDTO.of(
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
                                        product.getProduct().getMeasure().getUnit(),
                                        NutriScoreDTO.of(product.getProduct().getNutriScore().getId().toString(), product.getProduct().getNutriScore().getGrade())
                                )
                        ).collect(Collectors.toList())
                )
        );
    }

    public static RecipesDTO recipeToRecipeDTO(List<Recipe> recipes) {
        return RecipesDTO.of(recipes.stream().map(
                        recipe -> recipeToRecipeDTO(recipe)
        ).collect(Collectors.toList()));
    }

    public static UserListItemDTO userToUserListItemDTO(UserAccount userAccount){
        return UserListItemDTO.of(
                userAccount.getId().toString(),
                userAccount.getUsername(),
                userAccount.getInscriptionDate().toString()
        );
    }

    public static UserDTO userToUserDTO(UserAccount userAccount,int recipeNumber, int commentNumber){
        return UserDTO.of(
                userAccount.getId().toString(),
                userAccount.getUsername(),
                recipeNumber,
                commentNumber,
                userAccount.getInscriptionDate().toString()
        );
    }

    public static UserMeDTO userToUserMeDTO(UserAccount userAccount,int recipeNumber, int commentNumber){
        return UserMeDTO.of(
                userAccount.getId().toString(),
                userAccount.getUsername(),
                userAccount.getEmail(),
                recipeNumber,
                commentNumber,
                userAccount.getInscriptionDate().toString()
        );
    }

    public static UsersDTO usersToUsersDTO(List<UserAccount> userAccounts){
        return UsersDTO.of(userAccounts.stream().map(
                userAccount -> userToUserListItemDTO(userAccount)
        ).collect(Collectors.toList()));
    }

    public static CommentDTO commentToCommentDTO(Comment comment, String userId){
        return CommentDTO.of(
                comment.getId().toString(),
                comment.getBody(),
                comment.getUser().getId().toString().equals(userId),
                comment.getUser().getId().toString(),
                comment.getUser().getUsername(),
                comment.getPostedDate().toString()
        );
    }

    public static CommentsDTO commentsToCommentsDTO(List<Comment> comments, String userId){
        return CommentsDTO.of(comments.stream().map(
                comment -> commentToCommentDTO(comment, userId)
        ).collect(Collectors.toList()));
    }

    public static RatingsUserDTO ratingMapCategoryRatesTORatingsDTO(Map<Category, List<Rate>> categoryRatesMap, String userId){
        List<RatingUserDTO> RatingsUserList = new ArrayList<RatingUserDTO>();
        categoryRatesMap.forEach((k,v) -> {
            RatingCategoryDTO category = categoryToRatingCategoryDTO(k);
            Optional<Rate> userRating =  v.stream().filter(rate -> rate.getUser().getId().toString().equals(userId)).findAny();
            double rateScore = v.size() > 0 ? v.stream().map(r -> r.getRate()).reduce(0, Integer::sum) / v.size() : 0;
            RatingDTO ratingDTO = rateToRatingDTO(rateScore, category);
            RatingUserDTO ratingUserDTO = categoryToRatingUserDTO(ratingDTO, userRating.isPresent(), userRating.isPresent() ? userRating.get().getRate() : 0);
            RatingsUserList.add(ratingUserDTO);
        });
        return RatingsUserDTO.of(RatingsUserList);
    }

    public static RatingCategoryDTO categoryToRatingCategoryDTO(Category category){
        return RatingCategoryDTO.of(category.getId().toString(),category.getName());
    }

    public static RatingDTO rateToRatingDTO(double rate,RatingCategoryDTO categoryDTO){
        return RatingDTO.of(rate, categoryDTO);
    }

    public static RatingUserDTO categoryToRatingUserDTO(RatingDTO rating, boolean userRated, int userRating){
        return RatingUserDTO.of(rating,userRated ,userRating);
    }

    public static MeasureUniteDTO measureUniteToMeasureUniteDTO(MeasureUnit measureUnit) {
        return MeasureUniteDTO.of(measureUnit.getId().toString(), measureUnit.getUnit());
    }

    public static MeasuresUniteDTO measuresUniteListToMeasuresUniteDTO(List<MeasureUnit> measureUnits) {
        return MeasuresUniteDTO.of(measureUnits.stream().map(
                measure -> measureUniteToMeasureUniteDTO(measure)
        ).collect(Collectors.toList()));
    }
}
