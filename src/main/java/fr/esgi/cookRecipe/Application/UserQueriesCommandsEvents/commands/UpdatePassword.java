package fr.esgi.cookRecipe.Application.UserQueriesCommandsEvents.commands;

import fr.esgi.cookRecipe.Exposition.UserDTO.ModifyPasswordDTO;
import kernel.Command;

public class UpdatePassword implements Command {

    public final ModifyPasswordDTO modifyPasswordDTO;

    public UpdatePassword(ModifyPasswordDTO modifyPasswordDTO) {
        this.modifyPasswordDTO = modifyPasswordDTO;
    }

}
