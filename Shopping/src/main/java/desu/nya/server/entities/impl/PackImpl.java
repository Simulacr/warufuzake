package desu.nya.server.entities.impl;

import desu.nya.server.entities.Pack;
import desu.nya.server.entities.User;
import desu.nya.shared.enums.OrderStatus;
import java.sql.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

/**
 *
 * @author fess
 */
@Entity
@Table(name="PACK", schema="APP")
public class PackImpl extends GenericEntityImpl implements Pack{
    
    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="add_user_id")
    private UserImpl addedByUser;
    @Column(name="add_date")
    private Date addDate;
    @Column(name="name")
    private String name;
    @OneToMany(fetch=FetchType.EAGER, mappedBy="pack")
    @OrderBy("item")
    private List<OrderImpl> orders;
    @Column(name="status")
    private int status;
    

    @Override
    public User getAddedByUser() {
        return addedByUser;
    }

    @Override
    public void setAddedByUser(User user) {
        this.addedByUser = (UserImpl)user;
    }

    @Override
    public Date getAddDate() {
        return addDate;
    }

    @Override
    public void setAddDate(Date date) {
        this.addDate = date;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public List getOrders() {
        return orders;
    }

    @Override
    public void setOrders(List list) {
        this.orders = list;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public OrderStatus getOrderStatus() {
        return OrderStatus.convertFromCode(getStatus());
    }

    @Override
    public void setOrderStatus(OrderStatus status) {
       setStatus(status.getCode());
    }
}
