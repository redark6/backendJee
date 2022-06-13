package fr.esgi.cookRecipe.Domain.User.Repository;

import fr.esgi.cookRecipe.Domain.User.Entity.UserAccount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserAccountRepository extends PagingAndSortingRepository<UserAccount, UUID> {

    Page<UserAccount> findUserAccountsByUsernameContaining(String username, Pageable pagination);
    Optional<UserAccount> findUserAccountByEmail(String email);
}
