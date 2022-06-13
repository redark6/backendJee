package fr.esgi.cookRecipe.Application.UserQueriesCommandsEvents.commands;

import fr.esgi.cookRecipe.Exposition.UserDTO.ModifyMailDTO;
import kernel.Command;

public class UpdateMail implements Command {

    public final ModifyMailDTO modifyMailDTO;

    public UpdateMail(ModifyMailDTO modifyMailDTO) {
        this.modifyMailDTO = modifyMailDTO;
    }

}
