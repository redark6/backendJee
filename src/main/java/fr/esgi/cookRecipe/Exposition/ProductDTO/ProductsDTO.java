package fr.esgi.cookRecipe.Exposition.ProductDTO;

import java.util.List;

public class ProductsDTO {

    public final List<ProductDTO> products;

    public static ProductsDTO of(List<ProductDTO> products) {
        return new ProductsDTO(products);
    }

    private ProductsDTO(List<ProductDTO> products) {
        this.products = products;
    }
}
