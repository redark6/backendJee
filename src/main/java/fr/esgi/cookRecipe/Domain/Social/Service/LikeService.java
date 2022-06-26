package fr.esgi.cookRecipe.Domain.Social.Service;

import fr.esgi.cookRecipe.Domain.Recipe.Entity.Recipe;
import fr.esgi.cookRecipe.Domain.Social.Entity.Like;
import fr.esgi.cookRecipe.Domain.Social.Repository.LikeRepository;
import fr.esgi.cookRecipe.Domain.User.Entity.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class LikeService {
    private final LikeRepository likeRepository;

    @Autowired
    public LikeService(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    public void putlikeRecipe(Like userLikesRecipe){
        this.saveLike(userLikesRecipe);
    }

    public long getRecipeLikeScore(Recipe recipe){
        return this.likeRepository.countByRecipeAndLikedTrue(recipe);
    }

    public Optional<Like> findUserRecipeLike(Recipe recipe, UserAccount user){
        return this.likeRepository.findLikeByRecipeAndUser(recipe, user);
    }

    private void saveLike(Like userLikesRecipe) {
        this.likeRepository.save(userLikesRecipe);
    }
}
