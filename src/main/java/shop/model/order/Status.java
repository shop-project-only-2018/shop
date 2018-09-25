package shop.model.order;

import shop.model.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Status extends BaseEntity {

    @Id
    @GeneratedValue
    private int statusId;

    @Column()
    private String description;

    @OneToMany
    private List<Order> orders;

}
