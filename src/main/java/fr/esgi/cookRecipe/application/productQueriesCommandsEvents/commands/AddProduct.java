package fr.esgi.cookRecipe.application.productQueriesCommandsEvents.commands;

import fr.esgi.cookRecipe.exposition.ProductDTO.AddProductDTO;
import kernel.Command;

public class AddProduct implements Command {

	public final AddProductDTO addProductDTO;
	
	public AddProduct(AddProductDTO addProductDTO) {
		this.addProductDTO = addProductDTO;
	}
	
}
