package shop.system.exceptions;

public class EntityMappingException extends Exception {
    public EntityMappingException(String message) {
        super(message);
    }

    public EntityMappingException(Throwable cause) {
        super(cause);
    }

    public EntityMappingException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityMappingException() {
    }
}