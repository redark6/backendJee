package fr.esgi.cookRecipe.Domain.Product.Repository;

import org.springframework.stereotype.Repository;
import fr.esgi.cookRecipe.Domain.Product.Entity.NutriScore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface NutriScoreRepository extends JpaRepository<NutriScore, UUID> {
    Optional<NutriScore> getNutriScoreByGrade(char grade);
}
