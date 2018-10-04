package shop.dtos.order;

public class StatusDto {
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public StatusDto(String status) {
        this.status = status;
    }

    public StatusDto() {
    }
}
