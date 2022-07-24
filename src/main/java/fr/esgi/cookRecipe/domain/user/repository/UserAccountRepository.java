package fr.esgi.cookRecipe.domain.user.repository;

import fr.esgi.cookRecipe.domain.user.entity.UserAccount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserAccountRepository extends PagingAndSortingRepository<UserAccount, UUID> {
    Page<UserAccount> findUserAccountsByUsernameContaining(String username, Pageable pagination);
    Optional<UserAccount> findUserAccountByEmail(String email);
}
