package ybrs.shop.model.product;

import ybrs.shop.model.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Products")
public class Product extends BaseEntity {

    @ManyToMany
    @JoinTable(
            name = "Category_product",
            joinColumns = @JoinColumn(name = "Category_id", referencedColumnName = "Id"),
            inverseJoinColumns = @JoinColumn(name = "Product_id", referencedColumnName = "Id"))
    private List<Product> products;

}
