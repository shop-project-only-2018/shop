package shop.model;


import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.io.Serializable;

@MappedSuperclass
public abstract class AbstractVersionedEntity implements Serializable {

//    @Version
//    @Column
//    private Long version = 1L;

}