package fr.esgi.cookRecipe.application.userQueriesCommandsEvents.commands;

import fr.esgi.cookRecipe.domain.user.service.UserAccountService;
import kernel.CommandHandler;

public class UpdateMailHandler implements CommandHandler<UpdateMail, Void> {

    private final UserAccountService userAccountService;

    public UpdateMailHandler(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @Override
    public Void handle(UpdateMail query) {
        userAccountService.changeMail(query.modifyMailDTO.newMail);
        return null;
    }
}
