package desu.nya.services.shopping;



import desu.nya.server.entities.Measuring;
import desu.nya.server.entities.Order;
import desu.nya.server.entities.Pack;
import desu.nya.server.processors.shopping.OrderProcessor;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fess
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderProcessor orderProc;

    @Override
    @Transactional
    public List<Pack> getOpenedOrders() {
        return orderProc.getOpenedOrders();
    }
    
    @Override
    @Transactional
    public List<Order> getFullList() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Order createNewEntity() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void save(Order entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
//    @Override
    public void removeMeasuringList(List<Measuring> list) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void removeList(List<Order> list) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


  @Override
  public void removeList(Order[] list)
  {
    throw new UnsupportedOperationException("Not supported yet.");
  }

}
