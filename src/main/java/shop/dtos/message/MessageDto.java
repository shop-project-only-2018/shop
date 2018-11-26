package shop.dtos.message;

import shop.dtos.DTO;

import java.util.UUID;

public class MessageDto implements DTO {

    private UUID uuid;
    private String message;

    public MessageDto(UUID uuid, String message) {
        this.uuid = uuid;
        this.message = message;
    }

    public MessageDto() {
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
