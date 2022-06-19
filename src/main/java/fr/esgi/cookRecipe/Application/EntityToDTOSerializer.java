package fr.esgi.cookRecipe.Application;

import fr.esgi.cookRecipe.Domain.Product.Entity.NutriScore;
import fr.esgi.cookRecipe.Domain.Product.Entity.Product;
import fr.esgi.cookRecipe.Domain.Recipe.Entity.Recipe;
import fr.esgi.cookRecipe.Domain.User.Entity.UserAccount;
import fr.esgi.cookRecipe.Exposition.ProductDTO.NutriScoreDTO;
import fr.esgi.cookRecipe.Exposition.ProductDTO.NutriScoresDTO;
import fr.esgi.cookRecipe.Exposition.ProductDTO.ProductDTO;
import fr.esgi.cookRecipe.Exposition.ProductDTO.ProductsDTO;
import fr.esgi.cookRecipe.Exposition.RecipeDTO.RecipeDTO;
import fr.esgi.cookRecipe.Exposition.RecipeDTO.RecipeProductDTO;
import fr.esgi.cookRecipe.Exposition.RecipeDTO.RecipeProductsDTO;
import fr.esgi.cookRecipe.Exposition.RecipeDTO.RecipesDTO;
import fr.esgi.cookRecipe.Exposition.UserDTO.UserDTO;
import fr.esgi.cookRecipe.Exposition.UserDTO.UserMeDTO;
import fr.esgi.cookRecipe.Exposition.UserDTO.UsersDTO;

import java.util.List;
import java.util.stream.Collectors;

public class EntityToDTOSerializer {

    public static ProductDTO productToProductDTO(Product product){
        return ProductDTO.of(
                product.getId().toString(),
                product.getName(),
                product.getMesure().getUnit(),
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
                                        product.getProduct().getMesure().getUnit(),
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

    public static UserDTO userToUserDTO(UserAccount userAccount){
        return UserDTO.of(
                userAccount.getId().toString(),
                userAccount.getUsername(),
                userAccount.getRecipies().size(),
                5,
                userAccount.getInscriptionDate().toString()
        );
    }

    public static UserMeDTO userToUserMeDTO(UserAccount userAccount){
        return UserMeDTO.of(
                userAccount.getId().toString(),
                userAccount.getUsername(),
                userAccount.getEmail(),
                userAccount.getRecipies().size(),
                5,
                userAccount.getInscriptionDate().toString()
        );
    }

    public static UsersDTO usersToUsersDTO(List<UserAccount> userAccounts){
        return UsersDTO.of(userAccounts.stream().map(
                userAccount -> userToUserDTO(userAccount)
        ).collect(Collectors.toList()));
    }
}
