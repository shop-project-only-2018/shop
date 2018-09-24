package shop.model.order;

import shop.model.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "StatusCodes")
public class StatusCode extends BaseEntity {

    @Id
    @GeneratedValue
    private int statusCodeId;

    @Column(name="Description")
    private String description;

    @OneToMany
    private List<Order> orders;

}
