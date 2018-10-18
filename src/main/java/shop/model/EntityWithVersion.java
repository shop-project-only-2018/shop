package shop.model;


import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
public abstract class EntityWithVersion extends ModelEntity {

//    @Version
//    @Column
//    private Long version = 1L;

}