package fr.esgi.cookRecipe.Domain.Util.Repository;

import fr.esgi.cookRecipe.Domain.Util.Entity.MeasureUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface MeasureUniteRepository extends JpaRepository<MeasureUnit, UUID> {
    Optional<MeasureUnit> getMeasureUniteById(UUID id);
}
