package fr.esgi.cookRecipe.Application.UserQueriesCommandsEvents.queries;

import fr.esgi.cookRecipe.Domain.User.Entity.UserAccount;
import fr.esgi.cookRecipe.Domain.User.Service.UserAccountService;
import fr.esgi.cookRecipe.Exposition.UserDTO.UserDTO;
import fr.esgi.cookRecipe.Exposition.UserDTO.UsersDTO;
import kernel.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;

public class RetrieveUsersByUserNameLikeHandler implements QueryHandler<RetrieveUsersByUserNameLike, UsersDTO> {

    private final UserAccountService userAccountService;

    @Autowired
    public RetrieveUsersByUserNameLikeHandler(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @Override
    public UsersDTO handle(RetrieveUsersByUserNameLike query) {
        Pageable pageRequest = PageRequest.of(query.offset, query.limit);
        List<UserAccount> userAccounts = userAccountService.getUsersByUsername(query.usernamelike,pageRequest);
        return UsersDTO.of(userAccounts.stream()
                .map(userAccount ->
                        UserDTO.of(
                                userAccount.getId().toString(),
                                userAccount.getUsername(),
                                userAccount.getRecipies().size(),
                                5,
                                userAccount.getInscriptionDate().toString()
                        )
                ).collect(Collectors.toList())
        );
    }
}
