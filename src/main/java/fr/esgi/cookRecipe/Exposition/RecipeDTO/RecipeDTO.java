package fr.esgi.cookRecipe.Exposition.RecipeDTO;

import fr.esgi.cookRecipe.Exposition.ProductDTO.ProductsDTO;

public class RecipeDTO {
    private String id;
    private String name;
    private int shares;
    private Long executionTime;
    private double price;
    private RecipeProductsDTO products;

    public static RecipeDTO of(String id, String name, int shares, Long executionTime, double price, RecipeProductsDTO products) {
        return new RecipeDTO(id, name, shares, executionTime, price, products);
    }

    private RecipeDTO(String id, String name, int shares, Long executionTime, double price, RecipeProductsDTO products) {
        this.id = id;
        this.name = name;
        this.shares = shares;
        this.executionTime = executionTime;
        this.price = price;
        this.products = products;
    }

    @Override
    public String toString() {
        return "RecipeDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", shares=" + shares +
                ", executionTime=" + executionTime +
                ", price=" + price +
                ", products=" + products +
                '}';
    }
}
