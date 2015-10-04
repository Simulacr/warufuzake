package desu.nya.server.processors.nihongo.tekisto;

import desu.nya.server.entities.Tekisto;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * User: fess
 * Date: 05.01.15
 */
@Repository("tekistoProcessor")
public class TekistoProcessorImpl implements TekistoProcessor {
  @Autowired
  private SessionFactory sessionFactory;


  @Override
  @SuppressWarnings("unchecked")
  @Transactional
  public List<Tekisto> getAllTekisto() {
    return sessionFactory.getCurrentSession().createQuery("from TekistoImpl").list();
  }
}
