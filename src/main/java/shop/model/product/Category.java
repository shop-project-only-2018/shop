package shop.model.product;

import shop.model.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table()
public class Category extends BaseEntity {

    @Id
    @GeneratedValue
    private int categoryId;

    @Column()
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
