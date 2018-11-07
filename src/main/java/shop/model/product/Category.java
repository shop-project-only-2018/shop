package shop.model.product;

import shop.model.EntityWithIntegerId;

import javax.persistence.*;

@Entity
public class Category implements EntityWithIntegerId {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Category parent;

    public Category(Integer categoryId, String name, Category parent) {
        this.categoryId = categoryId;
        this.name = name;
        this.parent = parent;
    }

    public Category(Integer categoryId, String name) {
        this.categoryId = categoryId;
        this.name = name;
    }

    public Category(String name, Category parent) {
        this.name = name;
        this.parent = parent;
    }

    public Category(String name) {
        this.name = name;
    }

    public Category() {
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }

    @Override
    public Integer getId() {
        return categoryId;
    }

    @Override
    public void setId(Integer id) {
        this.categoryId = id;
    }
}
