package desu.nya.server.entities;

import desu.nya.shared.enums.OrderStatus;

/**
 *
 * @author fess
 */
public interface Order {
    Item getItem();
    void setItem(Item item);
    
    Pack getPack();
    void setPack(Pack pack);
    
    int getCount();
    void setCount(int count);
      
    OrderStatus getOrderStatus();
    void setOrderStatus(OrderStatus status);
}
