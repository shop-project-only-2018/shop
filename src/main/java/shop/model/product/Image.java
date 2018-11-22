package shop.model.product;

import shop.model.EntityWithIntegerId;

import javax.persistence.*;

@Entity
public class Image implements EntityWithIntegerId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int imageId;

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
    @Override
    public Integer getId() {
        return imageId;
    }

    @Override
    public void setId(Integer id) {
        this.imageId = id;
    }}
