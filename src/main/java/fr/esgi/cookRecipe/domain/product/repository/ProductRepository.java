package fr.esgi.cookRecipe.domain.product.repository;

import fr.esgi.cookRecipe.domain.product.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, UUID> {
    Page<Product> findProductByNameContainingOrderByNameAsc(String name, Pageable pagination);
}
