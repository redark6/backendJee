package fr.esgi.cookRecipe.application.userQueriesCommandsEvents.commands;

import fr.esgi.cookRecipe.domain.user.service.UserAccountService;
import kernel.CommandHandler;

public class UpdatePasswordHandler implements CommandHandler<UpdatePassword, Void> {

    private final UserAccountService userAccountService;

    public UpdatePasswordHandler(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @Override
    public Void handle(UpdatePassword query) {
        userAccountService.changePassword(query.modifyPasswordDTO.newPassword);
        return null;
    }
}
