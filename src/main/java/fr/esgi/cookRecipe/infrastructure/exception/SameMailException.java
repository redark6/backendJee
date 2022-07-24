package fr.esgi.cookRecipe.infrastructure.exception;

public class SameMailException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private SameMailException(String message) {
        super(message);
    }

    public static SameMailException withMail(String mail) {
        return new SameMailException(String.format("The new mail is the same as the previous one : %s", mail));
    }
}