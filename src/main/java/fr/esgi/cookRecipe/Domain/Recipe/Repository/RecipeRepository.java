package fr.esgi.cookRecipe.Domain.Recipe.Repository;

import fr.esgi.cookRecipe.Domain.Recipe.Entity.Recipe;
import fr.esgi.cookRecipe.Domain.User.Entity.UserAccount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface RecipeRepository extends PagingAndSortingRepository<Recipe, UUID> {
    int countByUser(UserAccount user);

    Iterable<Recipe> findAllByUser(UserAccount user);

    Page<Recipe> findAllByNameContaining(String name,Pageable pageable);
    Page<Recipe> findAllByProducts_Product_Id(UUID id,Pageable pageable);
    Page<Recipe> findAllByProducts_Product_NameContaining(String name,Pageable pageable);
}
