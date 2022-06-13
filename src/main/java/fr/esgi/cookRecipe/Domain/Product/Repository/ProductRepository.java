package fr.esgi.cookRecipe.Domain.Product.Repository;

import fr.esgi.cookRecipe.Domain.Product.Entity.Product;
import fr.esgi.cookRecipe.Domain.User.Entity.UserAccount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, UUID> {
    Page<Product> findProductByNameContaining(String name, Pageable pagination);

}
