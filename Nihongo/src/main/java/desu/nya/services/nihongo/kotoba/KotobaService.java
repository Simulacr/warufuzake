package desu.nya.services.nihongo.kotoba;

import desu.nya.server.entities.Kotoba;
import desu.nya.services.GenericService;

/**
 * User: Simulacr
 * Time: 22.11.14
 */
public interface KotobaService extends GenericService<Kotoba> {
  Integer getLastLessonNumber();
}
