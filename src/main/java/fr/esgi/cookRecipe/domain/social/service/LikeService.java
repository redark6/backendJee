package fr.esgi.cookRecipe.domain.social.service;

import fr.esgi.cookRecipe.domain.recipe.entity.Recipe;
import fr.esgi.cookRecipe.domain.social.entity.Like;
import fr.esgi.cookRecipe.domain.social.repository.LikeRepository;
import fr.esgi.cookRecipe.domain.user.entity.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
