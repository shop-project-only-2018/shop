package shop.model;


public interface EntityWithIntegerId {
    Integer getId();

    void setId(Integer id);

    default boolean isNew() {
        if (getId() == null) {
            return true;
        } else {
            return false;
        }
    }
}