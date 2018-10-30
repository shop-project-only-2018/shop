package shop.model.order;

import shop.model.EntityWithIntegerId;

import javax.persistence.*;

@Entity
public class Status implements EntityWithIntegerId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer statusId;

    @Column
    private String status;

    public Status() {
    }

    public Status(String status) {
        this.status = status;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    @Override
    public Integer getId() {
        return statusId;
    }

    @Override
    public void setId(Integer statusId) {
        this.statusId = statusId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
