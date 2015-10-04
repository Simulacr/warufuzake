package desu.nya.services.nihongo.tekisto;

import desu.nya.server.entities.Tekisto;
import desu.nya.server.entities.impl.TekistoImpl;
import desu.nya.server.processors.nihongo.tekisto.TekistoProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * User: fess
 * Date: 05.01.15
 */
@Service("tekistoService")
public class TekistoServiceImpl implements TekistoService {
  @Autowired
  private TekistoProcessor tekistoProcessor;

  @Override
  public Tekisto createNewEntity() {
    return new TekistoImpl();
  }

  @Override
  public void save(Tekisto entity) {
    //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  public void removeList(List<Tekisto> list) {
    //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  public void removeList(Tekisto[] list) {
    //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  public List<Tekisto> getFullList() {
    return tekistoProcessor.getAllTekisto();
  }
}
