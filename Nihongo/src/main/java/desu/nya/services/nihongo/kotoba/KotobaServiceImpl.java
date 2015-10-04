package desu.nya.services.nihongo.kotoba;

import desu.nya.server.entities.Kotoba;
import desu.nya.server.processors.nihongo.kotoba.KotobaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: Simulacr
 * Time: 22.11.14
 */
@Service("kotobaService")
public class KotobaServiceImpl implements KotobaService {
  @Autowired
  private KotobaProcessor processor;

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
}
