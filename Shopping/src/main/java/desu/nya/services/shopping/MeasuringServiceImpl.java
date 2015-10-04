package desu.nya.services.shopping;



import desu.nya.server.entities.Measuring;
import desu.nya.server.processors.shopping.MeasuringProcessor;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fess
 */
@Service("measuringService")
public class MeasuringServiceImpl implements MeasuringService{
    
    @Autowired
    private MeasuringProcessor measuringProcessor;

    @Override
    @Transactional
    public List<Measuring> getFullList() {
        return measuringProcessor.getMeasuringList();
    }
    
    @Override
    @Transactional
    public Measuring getMeasuringByUnit(String unit) {
        return measuringProcessor.getMeasuringByUnit(unit);
    }

    @Override
    public Measuring createNewEntity() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void save(Measuring entity) {
        measuringProcessor.addMeasuring(entity);
    }    

    @Override
    public void removeList(List<Measuring> list) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }


  @Override
  public void removeList(Measuring[] list)
  {
    //To change body of implemented methods use File | Settings | File Templates.
  }
}
