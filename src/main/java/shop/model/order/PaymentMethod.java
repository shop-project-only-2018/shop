package shop.model.order;

import shop.model.EntityWithIntId;

import javax.persistence.*;

@Entity
public class PaymentMethod implements EntityWithIntId {

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

    @Override
    public Integer getId() {
        return paymentMethodId;
    }

    @Override
    public void setId(Integer id) {
        this.paymentMethodId = id;
    }
}
