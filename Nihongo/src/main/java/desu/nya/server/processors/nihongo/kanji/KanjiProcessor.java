package desu.nya.server.processors.nihongo.kanji;

import desu.nya.server.entities.Kanji;
import java.util.List;

/**
 *
 * @author fess
 */
public interface KanjiProcessor {
    
    List<Kanji> getAllKanji();

  Kanji createNewKanji();

  void saveKanji(Kanji kanji);

  List<Kanji> getKanjiOfLesson(int lesson);

  List<Kanji> getKanjiBeforeLesson(int lesson);

  Integer getLastLessonNumber();

  Integer getLastKanjiNumber();
}
