package fr.esgi.cookRecipe.Domain.Util.Repository;

import fr.esgi.cookRecipe.Domain.Product.Entity.Product;
import fr.esgi.cookRecipe.Domain.Util.Entity.ProductLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductLogRepository extends JpaRepository<ProductLog, UUID> {
    ProductLog getProductLogByProduct(Product product);
    Page<ProductLog> getProductLogByProduct_NameContainingAndCountLessThan(String name, Pageable pageable, int count);
    Page<ProductLog> getProductLogByProduct_NameContainingOrderByCountDesc(String name, Pageable pageable);
}
