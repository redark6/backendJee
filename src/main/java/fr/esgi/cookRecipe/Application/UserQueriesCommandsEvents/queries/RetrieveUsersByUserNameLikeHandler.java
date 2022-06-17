package fr.esgi.cookRecipe.Application.UserQueriesCommandsEvents.queries;

import fr.esgi.cookRecipe.Application.EntityToDTOSerializer;
import fr.esgi.cookRecipe.Domain.User.Entity.UserAccount;
import fr.esgi.cookRecipe.Domain.User.Service.UserAccountService;
import fr.esgi.cookRecipe.Exposition.UserDTO.UsersDTO;
import kernel.QueryHandler;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class RetrieveUsersByUserNameLikeHandler implements QueryHandler<RetrieveUsersByUserNameLike, UsersDTO> {

    private final UserAccountService userAccountService;

    public RetrieveUsersByUserNameLikeHandler(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @Override
    public UsersDTO handle(RetrieveUsersByUserNameLike query) {
        Pageable pageRequest = PageRequest.of(query.offset, query.limit);
        List<UserAccount> userAccounts = userAccountService.getUsersByUsername(query.usernamelike,pageRequest);
        return EntityToDTOSerializer.usersToUsersDTO(userAccounts);
    }
}
