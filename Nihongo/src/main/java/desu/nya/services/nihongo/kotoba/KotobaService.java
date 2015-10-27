package desu.nya.services.nihongo.kotoba;

import desu.nya.server.entities.Kanji;
import desu.nya.server.entities.Kotoba;
import desu.nya.services.GenericService;
import desu.nya.services.nihongo.GenericLessonService;

import java.util.List;
import java.util.Set;

/**
 * User: Simulacr
 * Time: 22.11.14
 */
public interface KotobaService extends GenericLessonService<Kotoba> {
    List<Kotoba> getAllKotobaOfLessons(Set<Integer> lessons);

    List<String> getAllKanji();

    List<String> getAllKanjiBeforeLesson(int lesson);
}
