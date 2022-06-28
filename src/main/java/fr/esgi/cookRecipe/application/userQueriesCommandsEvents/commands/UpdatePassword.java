package fr.esgi.cookRecipe.application.userQueriesCommandsEvents.commands;

import fr.esgi.cookRecipe.exposition.UserDTO.ModifyPasswordDTO;
import kernel.Command;

public class UpdatePassword implements Command {

    public final ModifyPasswordDTO modifyPasswordDTO;

    public UpdatePassword(ModifyPasswordDTO modifyPasswordDTO) {
        this.modifyPasswordDTO = modifyPasswordDTO;
    }

}
