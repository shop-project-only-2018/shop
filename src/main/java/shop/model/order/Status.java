package shop.model.order;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Status implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int statusId;

    @Column
    private String status;

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Status() {
    }

    public Status(String status) {
        this.status = status;
    }
}
