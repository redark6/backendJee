package fr.esgi.cookRecipe.Infrastructure.Exception;

public class NoUserFormMailException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private NoUserFormMailException(String message) {
        super(message);
    }

    public static NoUserFormMailException withMail(String mail) {
        return new NoUserFormMailException(String.format("No user found for this mail : %s", mail));
    }
}