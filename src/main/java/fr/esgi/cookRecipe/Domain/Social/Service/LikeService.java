package fr.esgi.cookRecipe.Domain.Social.Service;

import fr.esgi.cookRecipe.Domain.Social.Entity.UserLikesRecipe;
import fr.esgi.cookRecipe.Domain.Social.Repository.LikeRepository;

import java.util.Optional;
import java.util.UUID;

public class LikeService {
    private final LikeRepository likeRepository;

    public LikeService(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    public void putlikeRecipe(UserLikesRecipe userLikesRecipe){
        this.saveLike(userLikesRecipe);
    }

    public Long getRecipeLikeScore(UUID recipeId){
        return this.likeRepository.countByRecipeIdAndLikedTrue(recipeId);
    }

    public Optional<UserLikesRecipe> findUserRecipeLike(UUID recipeId, String userId){
        return this.likeRepository.findUserLikesRecipeByRecipeIdAndUser_id(recipeId, userId);
    }

    private void saveLike(UserLikesRecipe userLikesRecipe) {
        this.likeRepository.save(userLikesRecipe);
    }
}
