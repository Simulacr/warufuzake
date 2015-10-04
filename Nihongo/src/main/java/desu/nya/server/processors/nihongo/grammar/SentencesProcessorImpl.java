package desu.nya.server.processors.nihongo.grammar;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * User: Simulacr
 * Time: 26.12.14
 */
@Repository("sentencesProcessor")
public class SentencesProcessorImpl implements SentencesProcessor {
  @Autowired
  private SessionFactory sessionFactory;


  @Override
  @SuppressWarnings("unchecked")
  @Transactional
  public List<String> getSentencesByLesson(int lesson) {
    return sessionFactory.getCurrentSession().createQuery("from SentencesImpl").list();
  }
}
