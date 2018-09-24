package shop.model.product;

import shop.model.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table()
public class Product extends BaseEntity {

    @Id
    @GeneratedValue
    private int productId;

    @Column
    private String name;

    @Column
    private BigDecimal price;

    @Column
    private int quantity;

    @ManyToOne
    private Category category;

}
