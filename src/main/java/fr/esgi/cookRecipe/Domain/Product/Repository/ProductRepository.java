package fr.esgi.cookRecipe.Domain.Product.Repository;

import fr.esgi.cookRecipe.Domain.Product.Entity.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, UUID> {
    Optional<Product> getProductByName(String name);
}
