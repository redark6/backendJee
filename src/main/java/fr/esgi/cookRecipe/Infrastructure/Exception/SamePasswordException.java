package fr.esgi.cookRecipe.Infrastructure.Exception;

public class SamePasswordException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private SamePasswordException(String message) {
        super(message);
    }

    public static SamePasswordException of() {
        return new SamePasswordException("New password is the same as the old one");
    }
}