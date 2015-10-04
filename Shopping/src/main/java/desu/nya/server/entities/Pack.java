package desu.nya.server.entities;

import desu.nya.shared.enums.OrderStatus;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author fess
 */
public interface Pack {
    
    User getAddedByUser();
    void setAddedByUser(User user);
    
    Date getAddDate();
    void setAddDate(Date date);
       
    String getName();
    void setName(String name);
    
    List<Order> getOrders();
    void setOrders(List<Order> list);
    
    OrderStatus getOrderStatus();
    void setOrderStatus(OrderStatus status);
}
