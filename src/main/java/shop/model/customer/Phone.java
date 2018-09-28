package shop.model.customer;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
public class Phone implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int phoneId;

    @Column()
    @NotEmpty
    @Digits(fraction = 0, integer = 10)
    private String number;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

}
