package fr.esgi.cookRecipe.domain.util.repository;

import fr.esgi.cookRecipe.domain.product.entity.Product;
import fr.esgi.cookRecipe.domain.util.entity.ProductLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductLogRepository extends JpaRepository<ProductLog, UUID> {
    ProductLog getProductLogByProduct(Product product);
    Page<ProductLog> getProductLogByProduct_NameContainingAndCountLessThan(String name, Pageable pageable, int count);
    Page<ProductLog> getProductLogByProduct_NameContainingOrderByCountDesc(String name, Pageable pageable);
}
