package ybrs.shop.model.order;

import ybrs.shop.model.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "StatusCodes")
public class StatusCode extends BaseEntity {

    @Column(name="Description")
    private String description;

    @OneToMany
    private List<Order> orders;

}
