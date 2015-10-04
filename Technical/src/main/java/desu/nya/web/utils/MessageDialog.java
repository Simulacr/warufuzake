package desu.nya.web.utils;

import desu.nya.shared.utils.Translator;
import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


public class MessageDialog
{
  @Autowired
  private Translator translator;

  public  void addMessage(String messageCode){
    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, translator.getString("Message"),
        translator.getString(messageCode));
    RequestContext.getCurrentInstance(). showMessageInDialog(message);
  }

  public void addMessage(String headerCode, String messageCode, String untranslatedAppend){
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(translator.getString(messageCode)
            + "\n" + untranslatedAppend));
//    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
//        translator.getString(headerCode),
//        translator.getString(messageCode) + untranslatedAppend);
//    RequestContext.getCurrentInstance(). showMessageInDialog(message);
  }

  public void setTranslator(Translator translator){
    this.translator = translator;
  }

  public  void addNotification(String messageCode){
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(translator.getString(messageCode)));
  }

  public void addNotification(String messageCode, String untranslatedAppend){
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(translator.getString(messageCode) + untranslatedAppend));
  }
}
