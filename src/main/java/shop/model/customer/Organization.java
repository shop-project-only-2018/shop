package shop.model.customer;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Organization implements Serializable {

//    @Id
//    private Integer customerId;
@Id
    @OneToOne
    @JoinColumn(name = "customer_id")
//    @MapsId
    private Customer customer;

    @Column
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
