package desu.nya.web.beans;

import java.io.Serializable;
import javax.faces.convert.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 *
 * @author fess
 */
@Controller("converters")
@Scope("session")
public class ConverterBean implements Serializable{
//    @Autowired
//    private MeasuringService measuringService;
//    
//    private Map<String, Converter> converters = new HashMap<String, Converter>();
//    
//    public Converter getConverter(String name){
//        return converters.get(name);
//    }
//    
//    @PostConstruct
//    public void init(){
//        converters.put("measuring", (Converter)measuringService);
//    }
}
