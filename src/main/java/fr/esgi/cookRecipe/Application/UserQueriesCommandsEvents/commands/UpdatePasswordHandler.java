package fr.esgi.cookRecipe.Application.UserQueriesCommandsEvents.commands;

import fr.esgi.cookRecipe.Domain.User.Service.UserAccountService;
import kernel.CommandHandler;
import org.springframework.beans.factory.annotation.Autowired;

public class UpdatePasswordHandler implements CommandHandler<UpdatePassword, Void> {

    private final UserAccountService userAccountService;

    @Autowired
    public UpdatePasswordHandler(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @Override
    public Void handle(UpdatePassword query) {
        userAccountService.changePassword(query.modifyPasswordDTO.newPassword);
        return null;
    }
}
