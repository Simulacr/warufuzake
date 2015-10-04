package desu.nya.web.beans;

import java.io.Serializable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 *
 * @author fess
 */
@Controller("webUtils")
@Scope("session")
public class WebUtilsBean implements Serializable{
    
    public static String getColorByStatus(int code)
    {
        switch(code)
        {
            case 1: return "red";
            case 2: return "yellow";
            case 0: 
            default: return null;
        }
    }
    
}
