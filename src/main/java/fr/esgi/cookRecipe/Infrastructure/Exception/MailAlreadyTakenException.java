package fr.esgi.cookRecipe.Infrastructure.Exception;

public class MailAlreadyTakenException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private MailAlreadyTakenException(String message) {
        super(message);
    }

    public static MailAlreadyTakenException withMail(String mail) {
        return new MailAlreadyTakenException(String.format("This mail is already used : %s", mail));
    }
}
