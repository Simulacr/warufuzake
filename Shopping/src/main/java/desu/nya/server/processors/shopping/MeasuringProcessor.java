package desu.nya.server.processors.shopping;

import desu.nya.server.entities.Measuring;
import java.util.List;

/**
 *
 * @author fess
 */
public interface MeasuringProcessor {
    
    List<Measuring> getMeasuringList();
    
    Measuring createNewMeasuring();
    
    void addMeasuring(Measuring measuring);
    
    Measuring getMeasuringByUnit(String unit);
}
