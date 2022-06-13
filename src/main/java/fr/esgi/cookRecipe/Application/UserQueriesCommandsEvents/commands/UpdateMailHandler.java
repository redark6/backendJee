package fr.esgi.cookRecipe.Application.UserQueriesCommandsEvents.commands;

import fr.esgi.cookRecipe.Domain.User.Service.UserAccountService;
import kernel.CommandHandler;
import org.springframework.beans.factory.annotation.Autowired;

public class UpdateMailHandler implements CommandHandler<UpdateMail, Void> {

    private final UserAccountService userAccountService;

    @Autowired
    public UpdateMailHandler(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @Override
    public Void handle(UpdateMail query) {
        userAccountService.changeMail(query.modifyMailDTO.newMail);
        return null;
    }
}
