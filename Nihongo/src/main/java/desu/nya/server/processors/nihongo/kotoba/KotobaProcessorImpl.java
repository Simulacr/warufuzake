package desu.nya.server.processors.nihongo.kotoba;

import desu.nya.server.entities.Kotoba;
import desu.nya.server.entities.impl.KotobaImpl;
import desu.nya.server.processors.GenericProcessorImpl;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 * @author fess
 */
@Repository("kotobaProcessor")
public class KotobaProcessorImpl extends GenericProcessorImpl<Kotoba> implements KotobaProcessor {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    @Transactional
    public List<Kotoba> getAllKotoba() {
        return sessionFactory.getCurrentSession().createQuery("from KotobaImpl").list();
    }

  @Override
  public Kotoba createNewKotoba() {
    return new KotobaImpl();
  }

  @Override
  @SuppressWarnings("unchecked")
  @Transactional
  public void saveKotoba(Kotoba kotoba) {
    sessionFactory.getCurrentSession().save(kotoba);
  }

  @Override
  @SuppressWarnings("unchecked")
  @Transactional
  public Integer getLastLessonNumber() {
    return ((Kotoba)getCriteria(Kotoba.class).addOrder(Order.desc("lesson")).setMaxResults(1).uniqueResult()).getLesson();
  }
}
