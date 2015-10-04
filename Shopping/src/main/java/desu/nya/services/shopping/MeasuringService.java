package desu.nya.services.shopping;



import desu.nya.server.entities.Measuring;
import desu.nya.services.GenericService;

import javax.faces.convert.Converter;

/**
 *
 * @author fess
 */
public interface MeasuringService  extends GenericService<Measuring>{
       
    public Measuring getMeasuringByUnit(String unit);
}
