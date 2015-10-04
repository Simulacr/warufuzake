package desu.nya.server.processors;

import desu.nya.server.entities.GenericEntity;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * User: ievstratov
 * Date: 13.01.15
 */
public class GenericProcessorImpl<E extends GenericEntity> {
  @Autowired
  private SessionFactory sessionFactory;

  @SuppressWarnings("unchecked")
  @Transactional
  protected Criteria getCriteria(Class clazz) {
    return sessionFactory.getCurrentSession().createCriteria(clazz);
  }

  @SuppressWarnings("unchecked")
  @Transactional
  protected List<E> getFullList(Class clazz) {
    return getCriteria(clazz).list();
  }

  @SuppressWarnings("unchecked")
  @Transactional
  protected void save(E item) {
    sessionFactory.getCurrentSession().save(item);
  }
}
