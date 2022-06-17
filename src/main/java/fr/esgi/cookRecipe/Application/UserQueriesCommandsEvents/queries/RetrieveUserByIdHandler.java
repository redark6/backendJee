package fr.esgi.cookRecipe.Application.UserQueriesCommandsEvents.queries;

import fr.esgi.cookRecipe.Application.EntityToDTOSerializer;
import fr.esgi.cookRecipe.Domain.User.Entity.UserAccount;
import fr.esgi.cookRecipe.Domain.User.Service.UserAccountService;
import fr.esgi.cookRecipe.Exposition.UserDTO.UserDTO;
import kernel.QueryHandler;

import java.util.UUID;

public class RetrieveUserByIdHandler implements QueryHandler<RetrieveUserById, UserDTO>{

    private final UserAccountService userAccountService;

    public RetrieveUserByIdHandler(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }
// to do get comment number
    @Override
    public UserDTO handle(RetrieveUserById query) {
    	UUID userId = UUID.fromString(query.userId);
    	UserAccount userAccount = userAccountService.getUserById(userId);
        return EntityToDTOSerializer.userToUserDTO(userAccount);
    }
}