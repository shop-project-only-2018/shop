package shop.dtos.order;

import javax.validation.constraints.NotEmpty;

public class PaymentMethodDto {
    private Integer paymentMethodId;
    @NotEmpty
    private String description;

    public Integer getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(Integer paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PaymentMethodDto() {
    }

    public PaymentMethodDto(@NotEmpty String description) {
        this.description = description;
    }

    public PaymentMethodDto(Integer paymentMethodId, @NotEmpty String description) {
        this.paymentMethodId = paymentMethodId;
        this.description = description;
    }
}
