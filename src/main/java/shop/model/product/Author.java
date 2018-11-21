package shop.model.product;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import shop.model.EntityWithIntegerId;
import shop.model.customer.Role;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Author implements EntityWithIntegerId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer authorId;

    @Column
    private String firstName;

    @Column
    private String lastName;

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public Integer getId() {
        return getAuthorId();
    }

    @Override
    public void setId(Integer id) {
        setAuthorId(id);
    }
}
