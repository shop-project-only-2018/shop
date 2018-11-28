package shop.model.order;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import shop.model.EntityWithIntegerId;
import shop.model.customer.Customer;
import shop.model.product.Book;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order implements EntityWithIntegerId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    @Column
    private BigDecimal price;

    @Column
    private Timestamp added;

    @Column
    private Boolean done = false;//TODO:REDO

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "status_id")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "payment_method_id")
    private PaymentMethod paymentMethod;

    @OneToMany(mappedBy = "order")
    private Set<OrderItem> orderItems;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public void unNullOrderItems() {
        if (this.orderItems == null) {
            this.orderItems = new HashSet<>();
        }
    }

    public void addOrderItem(OrderItem orderItem) {
        unNullOrderItems();
        this.orderItems.add(orderItem);
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Timestamp getAdded() {
        return added;
    }

    public void setAdded(Timestamp added) {
        this.added = added;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Order() {
        this.added = new Timestamp(0);
    }

    @Override
    public Integer getId() {
        return orderId;
    }

    @Override
    public void setId(Integer id) {
        this.orderId = id;
    }

    public boolean contains(Book book) {
        unNullOrderItems();
        for(OrderItem item : this.orderItems){if(item.getBook() == book){
            return true;}}
        return false;
    }
}
