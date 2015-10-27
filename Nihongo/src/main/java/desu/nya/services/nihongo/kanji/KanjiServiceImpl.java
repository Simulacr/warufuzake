package desu.nya.services.nihongo.kanji;

import desu.nya.server.entities.Kanji;
import desu.nya.server.processors.nihongo.kanji.KanjiProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: Simulacr
 * Time: 22.11.14
 */
@Service("kanjiService")
public class KanjiServiceImpl implements KanjiService {
  @Autowired
  private KanjiProcessor processor;

  @Override
  public Kanji createNewEntity() {
    return processor.createNewKanji();
  }

  @Override
  public void save(Kanji entity) {
    processor.saveKanji(entity);
  }

  @Override
  public void removeList(List<Kanji> list) {

  }

  @Override
  public void removeList(Kanji[] list) {

  }

  @Override
  public List<Kanji> getFullList() {
    return processor.getAllKanji();
  }

  @Override
  public List<Kanji> getListOfLesson(int lesson) {
    return processor.getKanjiOfLesson(lesson);
  }

  @Override
  public Integer getLastLessonNumber() {
    return processor.getLastLessonNumber();
  }

  @Override
  public Integer getLastNumber() {
    return processor.getLastKanjiNumber();
  }
}
