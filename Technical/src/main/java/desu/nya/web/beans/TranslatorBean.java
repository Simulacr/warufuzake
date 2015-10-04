package desu.nya.web.beans;

import desu.nya.shared.utils.Translator;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 *
 * @author fess
 */
@Controller("translatorBean")
@Scope("request")
public class TranslatorBean {
    @Autowired
    private Translator translator;
    
    @PostConstruct
    public void init()
    {
        translator.refreshLocale();
    }
    
    public String getString(String code)
    {
        return translator.getString(code);
    }
}
