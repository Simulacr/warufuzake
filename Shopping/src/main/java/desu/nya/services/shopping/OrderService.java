package desu.nya.services.shopping;



import desu.nya.server.entities.Order;
import desu.nya.server.entities.Pack;
import desu.nya.services.GenericService;
import java.util.List;

/**
 *
 * @author fess
 */
public interface OrderService  extends GenericService<Order>{
    
    List<Pack> getOpenedOrders();
}
