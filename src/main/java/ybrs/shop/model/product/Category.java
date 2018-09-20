package ybrs.shop.model.product;

import ybrs.shop.model.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Products")
public class Category extends BaseEntity {

    @Column(name = "Name")
    private String name;

    @Column(name = "Description")
    private String description;

    @ManyToMany
    @JoinTable(
            name = "Category_to_category_mapping",
            joinColumns = @JoinColumn(name = "Parent_id", referencedColumnName = "Id"),
            inverseJoinColumns = @JoinColumn(name = "Child_id", referencedColumnName = "Id"))
    private List<Category> parents;

    @ManyToMany
    @JoinTable(
            name = "Category_to_category_mapping",
            joinColumns = @JoinColumn(name = "Child_id", referencedColumnName = "Id"),
            inverseJoinColumns = @JoinColumn(name = "Parent_id", referencedColumnName = "Id"))
    private List<Category> children;

    @ManyToMany
    @JoinTable(
            name = "Category_product",
            joinColumns = @JoinColumn(name = "Category_id", referencedColumnName = "Id"),
            inverseJoinColumns = @JoinColumn(name = "Product_id", referencedColumnName = "Id"))
    private List<Product> products;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Category> getParents() {
        return parents;
    }

    public void setParents(List<Category> parents) {
        this.parents = parents;
    }

    public List<Category> getChildren() {
        return children;
    }

    public void setChildren(List<Category> children) {
        this.children = children;
    }
}
