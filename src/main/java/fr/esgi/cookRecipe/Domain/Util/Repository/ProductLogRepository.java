package fr.esgi.cookRecipe.Domain.Util.Repository;

import fr.esgi.cookRecipe.Domain.Util.Entity.ProductLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductLogRepository extends JpaRepository<ProductLog, UUID> {
}
