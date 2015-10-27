package desu.nya.services.nihongo.kanji;

import desu.nya.server.entities.Kanji;
import desu.nya.services.GenericService;
import desu.nya.services.nihongo.GenericLessonService;

import java.util.List;

/**
 * User: Simulacr
 * Time: 22.11.14
 */
public interface KanjiService extends GenericLessonService<Kanji> {

  Integer getLastNumber();
}
