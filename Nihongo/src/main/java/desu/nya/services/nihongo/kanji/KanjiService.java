package desu.nya.services.nihongo.kanji;

import desu.nya.server.entities.Kanji;
import desu.nya.services.GenericService;

import java.util.List;

/**
 * User: Simulacr
 * Time: 22.11.14
 */
public interface KanjiService extends GenericService<Kanji> {

  List<Kanji> getKanjiOfLesson(int lesson);

  Integer getLastLessonNumber();

  Integer getLastNumber();
}
