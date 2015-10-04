package desu.nya.server.entities.impl;

import desu.nya.server.entities.Item;
import desu.nya.server.entities.Order;
import desu.nya.server.entities.Pack;
import desu.nya.shared.enums.OrderStatus;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author fess
 */
@Entity
@Table(name="ORDERS", schema="APP")
public class OrderImpl extends GenericEntityImpl implements Order{
    
    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="item_id")
    private ItemImpl item;
    @Column(name="ORDERS_COUNT")
    private int count;
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="pack_id")
    private PackImpl pack;
    @Column(name="status")
    private int status;

    @Override
    public Item getItem() {
        return item;
    }

    @Override
    public void setItem(Item item) {
        this.item = (ItemImpl)item;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public Pack getPack() {
        return pack;
    }

    @Override
    public void setPack(Pack pack) {
        this.pack = (PackImpl)pack;
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
