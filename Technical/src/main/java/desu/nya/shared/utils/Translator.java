package desu.nya.shared.utils;

import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

/**
 *
 * @author fess
 */
public class Translator{
    
    private Locale locale;
    private Locale defaultLocale = new Locale("en");
    @Autowired
    private ReloadableResourceBundleMessageSource messageSource;
    
    public void refreshLocale()
    {
        String localeName = UserUtils.getCurrentUser() != null ?
                UserUtils.getCurrentUser().getLocution().getName() : null;
        locale = localeName != null ? new Locale(localeName) : null;
    }
    
    public void setDefaultLocale(String defaultLocale)
    {
        this.defaultLocale = new Locale(defaultLocale);
    }
    
    public void setMessageSource(ReloadableResourceBundleMessageSource messageSource)
    {
        this.messageSource = messageSource;
    }
        
    public String getString(String message)
    {
        return getString(message, null);
    }
    
    public String getString(String message, Object[] obj)
    {
        try{
            return messageSource == null ? message : messageSource.getMessage(message, obj, getCurrentLocale());
        }
        catch(org.springframework.context.NoSuchMessageException ex)
        {
            return "@" + message;
        }
    }
    
    private Locale getCurrentLocale()
    {
        return locale == null ? defaultLocale : locale;
    }
}
