package kernel;

import java.util.UUID;

public final class NoSuchEntityException extends RuntimeException {

    public NoSuchEntityException(String message) {
        super(message);
    }

    public static NoSuchEntityException withId(UUID id) {
    	return new NoSuchEntityException(String.format("No entity found with ID %s.", id.toString()));
    }
    
    public static NoSuchEntityException withIdAndElem(UUID id, String element) {
		return new NoSuchEntityException(String.format("No "+ element +" found with ID %s.", id.toString()));
    }

    public static NoSuchEntityException withNameAndElem(String name, String element) {
        return new NoSuchEntityException(String.format("No "+ element +" found with name %s.", name));
    }
}
