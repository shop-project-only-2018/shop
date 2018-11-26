package shop.model.customer;

import shop.model.EntityWithIntegerId;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role implements EntityWithIntegerId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;

    @Column
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public Integer getId() {
        return roleId;
    }

    @Override
    public void setId(Integer id) {
        this.roleId = id;
    }
}
