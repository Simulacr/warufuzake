package desu.nya.server.processors.shopping;

import desu.nya.server.entities.Order;
import desu.nya.server.entities.Pack;
import java.util.List;

/**
 *
 * @author fess
 */
public interface OrderProcessor {
    
    List<Pack> getOpenedOrders();
    
    Order createNewOrder();
}
