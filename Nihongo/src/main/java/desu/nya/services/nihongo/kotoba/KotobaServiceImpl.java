package desu.nya.services.nihongo.kotoba;

import desu.nya.server.entities.Kanji;
import desu.nya.server.entities.Kotoba;
import desu.nya.server.processors.nihongo.kanji.KanjiProcessor;
import desu.nya.server.processors.nihongo.kotoba.KotobaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * User: Simulacr
 * Time: 22.11.14
 */
@Service("kotobaService")
public class KotobaServiceImpl implements KotobaService {
  @Autowired
  private KotobaProcessor processor;
  @Autowired
  private KanjiProcessor kanjiProcessor;

  @Override
  public Kotoba createNewEntity() {
    return processor.createNewKotoba();
  }

  @Override
  public void save(Kotoba entity) {
    processor.saveKotoba(entity);
  }

  @Override
  public void removeList(List<Kotoba> list) {

  }

  @Override
  public void removeList(Kotoba[] list) {

  }

  @Override
  public List<Kotoba> getFullList() {
    return processor.getAllKotoba();
  }

  @Override
  public Integer getLastLessonNumber() {
    return processor.getLastLessonNumber();
  }

  @Override
  public List<Kotoba> getListOfLesson(int lesson) {
    return null;
  }

  @Override
  public List<Kotoba> getAllKotobaOfLessons(Set<Integer> lessons) {
    return processor.getAllKotobaOfLessons(lessons);
  }

  @Override
  public List<String> getAllKanji() {
    return kanjiProcessor.getAllKanji().stream().map(Kanji::getKanji).collect(Collectors.toList());
  }

  @Override
  public List<String> getAllKanjiBeforeLesson(int lesson) {
    return kanjiProcessor.getKanjiBeforeLesson(lesson).stream().map(Kanji::getKanji).collect(Collectors.toList());
  }
}
