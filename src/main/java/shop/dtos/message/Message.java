package shop.dtos.message;

import shop.dtos.DTO;

public class Message implements DTO {
    /**
     * false = no errors
     */
    private Boolean error = Boolean.FALSE;
    private String message;

    public Message() {
    }

    public Message(String message) {
        this.message = message;
    }

    public Message(Boolean error, String message) {
        this.error = error;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }
}
