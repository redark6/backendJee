package fr.esgi.cookRecipe.Application.UserQueriesCommandsEvents.commands;

import fr.esgi.cookRecipe.Domain.User.Service.UserAccountService;
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
