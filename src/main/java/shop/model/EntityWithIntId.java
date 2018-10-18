package shop.model;


import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.io.Serializable;

@MappedSuperclass
public abstract class EntityWithIntId extends EntityWithVersion {

    public abstract void setId(Integer id);

    public abstract Integer getId();


}