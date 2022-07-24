package fr.esgi.cookRecipe.domain.util.repository;

import fr.esgi.cookRecipe.domain.util.entity.MeasureUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface MeasureUniteRepository extends JpaRepository<MeasureUnit, UUID> {
    Optional<MeasureUnit> getMeasureUniteById(UUID id);
    Optional<MeasureUnit> getMeasureUnitsByUnit(String unite);
}
