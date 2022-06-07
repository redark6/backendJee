package fr.esgi.cookRecipe.Application.ProductQueriesCommandsEvents.commands;

import fr.esgi.cookRecipe.Exposition.ProductDTO.AddProductDTO;
import kernel.Command;

public class AddProduct implements Command {

	public final AddProductDTO addProductDTO;
	
	public AddProduct(AddProductDTO addProductDTO) {
		this.addProductDTO = addProductDTO;
	}
	
}
