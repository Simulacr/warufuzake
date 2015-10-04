package desu.nya.web.wrappers;

import desu.nya.server.entities.Measuring;
import desu.nya.services.shopping.MeasuringService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 *
 * @author fess
 */
@Controller("measuringConverter")
@FacesConverter("measuringConverter")
@Scope("session")
public class MeasuringWrapper implements Converter, Serializable{
    @Autowired
    private MeasuringService measuringService; 
    
    private static List<Measuring> measurings;
    
    @PostConstruct
    public void init(){
        measurings = measuringService.getFullList();
    }
    
    
    public List<Measuring> getAllMeasuring(){
        return measurings;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        for(Measuring item : measurings)
        {
            if(item.getUnit().equals(value)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return value.toString();
    }
}
