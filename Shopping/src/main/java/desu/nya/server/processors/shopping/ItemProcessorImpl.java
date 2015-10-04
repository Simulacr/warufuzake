package desu.nya.server.processors.shopping;

import desu.nya.server.entities.Item;
import desu.nya.server.entities.impl.ItemImpl;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fess
 */
@Repository("itemProcessor")
public class ItemProcessorImpl implements ItemProcessor{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    @Transactional
    public void addItem(Item item) {
        sessionFactory.getCurrentSession().save(item);
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional
    public List<Item> getAllItem() {
        return sessionFactory.getCurrentSession().createQuery("from ItemImpl").list();
    }

    @Override
    public List<Item> getAllDrinks() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Item> geAllFood() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional
    public void removeItem(Item item) {
        sessionFactory.getCurrentSession().delete(item);
    }

    @Override
    public Item createNewItem() {
        return new ItemImpl();
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional
    public void removeItems(List<Item> list) {
        if(list != null)
          for(Item item : list)
            sessionFactory.getCurrentSession().delete(item);
    }
}
