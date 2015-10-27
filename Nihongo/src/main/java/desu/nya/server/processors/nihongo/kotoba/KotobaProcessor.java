package desu.nya.server.processors.nihongo.kotoba;

import desu.nya.server.entities.Kotoba;

import java.util.List;
import java.util.Set;

/**
 *
 * @author fess
 */
public interface KotobaProcessor {
    
    List<Kotoba> getAllKotoba();

  Kotoba createNewKotoba();

  void saveKotoba(Kotoba kotoba);

  Integer getLastLessonNumber();

    List<Kotoba> getAllKotobaOfLessons(Set<Integer> lessons);
}
