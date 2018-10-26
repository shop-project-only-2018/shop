package shop.model;


public interface EntityWithIntId {
    Integer getId();
    void setId(Integer id);
    default boolean isNew() {
        if(getId() == null){
            return true;}else {
            return false;
        }
    }
}