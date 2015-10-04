package desu.nya.server.processors.shopping;

import desu.nya.server.entities.Order;
import desu.nya.server.entities.Pack;
import desu.nya.server.entities.impl.OrderImpl;
import desu.nya.shared.enums.OrderStatus;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fess
 */
@Repository("orderProcessor")
public class OrderProcessorImpl implements OrderProcessor{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    @Transactional
    public List<Pack> getOpenedOrders() {
        return sessionFactory.getCurrentSession().createQuery("from PackImpl where status=" + OrderStatus.OPEN.getCode())
//                createCriteria(PackImpl.class).add(Restrictions.eq("status", OrderStatus.OPEN.getCode()))
                        .list();
    }

    @Override
    public Order createNewOrder() {
        return new OrderImpl();
    }
    
}
