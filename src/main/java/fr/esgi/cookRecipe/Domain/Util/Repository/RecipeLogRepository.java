package fr.esgi.cookRecipe.Domain.Util.Repository;

import fr.esgi.cookRecipe.Domain.Util.Entity.RecipeLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface RecipeLogRepository extends JpaRepository<RecipeLog, UUID> {
    List<RecipeLog> ge(Iterable<UUID> uuids);
}
