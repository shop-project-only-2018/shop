package ybrs.shop.model;


import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Entity {

    @Id
    @GeneratedValue
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
