package fr.esgi.cookRecipe.domain.util.repository;

import fr.esgi.cookRecipe.domain.util.entity.ResearchLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface ResearchLogRepository extends JpaRepository<ResearchLog, UUID> {
}
