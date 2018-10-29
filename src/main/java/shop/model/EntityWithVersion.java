package shop.model;


import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class EntityWithVersion extends ModelEntity {

//    @Version
//    @Column
//    private Long version = 1L;

}