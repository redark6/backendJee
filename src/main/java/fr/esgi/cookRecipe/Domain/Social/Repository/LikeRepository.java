package fr.esgi.cookRecipe.Domain.Social.Repository;

import fr.esgi.cookRecipe.Domain.Social.Entity.UserLikesRecipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LikeRepository extends JpaRepository<UserLikesRecipe, UUID> {

}
