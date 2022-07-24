package fr.esgi.cookRecipe.infrastructure.exception;

public class NegativePriceException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private NegativePriceException(String message) {
        super(message);
    }

    public static NegativePriceException withPrice(double price) {
        return new NegativePriceException(String.format("Negative price found for this recipe : %s €", price));
    }
}
