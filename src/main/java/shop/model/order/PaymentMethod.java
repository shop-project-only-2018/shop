package shop.model.order;

import shop.model.AbstractVersionedEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class PaymentMethod extends AbstractVersionedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentMethodId;

    @Column
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

    public PaymentMethod(String description) {
        this.description = description;
    }

    public PaymentMethod() {
    }
}
