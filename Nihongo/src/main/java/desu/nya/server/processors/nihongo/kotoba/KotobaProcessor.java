package desu.nya.server.processors.nihongo.kotoba;

import desu.nya.server.entities.Kotoba;

import java.util.List;

/**
 *
 * @author fess
 */
public interface KotobaProcessor {
    
    List<Kotoba> getAllKotoba();

  Kotoba createNewKotoba();

  void saveKotoba(Kotoba kotoba);

  Integer getLastLessonNumber();
}
