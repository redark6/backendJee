package fr.esgi.cookRecipe.application.userQueriesCommandsEvents.commands;

import fr.esgi.cookRecipe.exposition.UserDTO.ModifyMailDTO;
import kernel.Command;

public class UpdateMail implements Command {

    public final ModifyMailDTO modifyMailDTO;

    public UpdateMail(ModifyMailDTO modifyMailDTO) {
        this.modifyMailDTO = modifyMailDTO;
    }

}
