package shop.model.customer;

import shop.model.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;

@Entity
@Table()
public class Phone extends BaseEntity {

    @Id
    @GeneratedValue
    private int phoneId;

    @Column()
    @NotEmpty
    @Digits(fraction = 0, integer = 10)
    private String number;

}
