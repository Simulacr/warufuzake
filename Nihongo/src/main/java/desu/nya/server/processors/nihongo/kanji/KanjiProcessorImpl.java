package desu.nya.server.processors.nihongo.kanji;

import desu.nya.server.entities.Kanji;
import java.util.List;

import desu.nya.server.entities.impl.KanjiImpl;
import desu.nya.server.processors.GenericProcessorImpl;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fess
 */
@Repository("kanjiProcessor")
public class KanjiProcessorImpl extends GenericProcessorImpl<Kanji> implements KanjiProcessor{

    @Override
    @SuppressWarnings("unchecked")
    @Transactional
    public List<Kanji> getAllKanji() {
        return getFullList(Kanji.class);
    }

  @Override
  public Kanji createNewKanji() {
    return new KanjiImpl();
  }

  @Override
  @SuppressWarnings("unchecked")
  @Transactional
  public void saveKanji(Kanji kanji) {
    save(kanji);
  }

  @Override
  @SuppressWarnings("unchecked")
  @Transactional
  public List<Kanji> getKanjiOfLesson(int lesson) {
    Criteria criteria = getCriteria(Kanji.class);
    if(lesson > -1)
      criteria.add(Restrictions.eq("lesson", lesson));
    return criteria.list();
  }

  @Override
  public List<Kanji> getKanjiBeforeLesson(int lesson) {
    Criteria criteria = getCriteria(Kanji.class);
    if(lesson > -1)
      criteria.add(Restrictions.le("lesson", lesson));
    return criteria.list();
  }

  @Override
  @SuppressWarnings("unchecked")
  @Transactional
  public Integer getLastLessonNumber() {
    return ((Kanji)getCriteria(Kanji.class).addOrder(Order.desc("lesson")).setMaxResults(1).uniqueResult()).getLesson();
  }

  @Override
  @SuppressWarnings("unchecked")
  @Transactional
  public Integer getLastKanjiNumber() {
    return ((Kanji)getCriteria(Kanji.class).addOrder(Order.desc("number")).setMaxResults(1).uniqueResult()).getNumber();
  }
}
