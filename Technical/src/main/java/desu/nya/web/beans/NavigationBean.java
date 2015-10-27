package desu.nya.web.beans;

import desu.nya.shared.exceptions.FunctionalException;
import desu.nya.web.forms.GenericForm;
import desu.nya.web.utils.NavigationUtils;
import desu.nya.web.forms.GenericFormManipulator;
import desu.nya.web.forms.GenericListForm;
import desu.nya.web.forms.GenericUpdateForm;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import desu.nya.web.utils.MessageDialog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * @author fess
 */
@Controller("navigation")
@Scope("session")
public class NavigationBean implements Serializable {
  @Autowired
  private AutowireCapableBeanFactory factory;
  @Autowired
  private MessageDialog messageDialog;
  @Autowired
  private NavigationUtils navigationUtils;

  private GenericFormManipulator formManipulator;


  public String navigateTo(String page) {
    if (page != null)
      try {
        formManipulator = navigationUtils.createManipulator(page, factory);
      } catch (FunctionalException e) {
        messageDialog.addMessage(e.getMessage());
      }

    return null;
  }

  public void navigateToHome() {
    formManipulator = null;
  }

  public String getPageToNavigate() {
    String page =  formManipulator.getCurrentForm() == null ? "" :
            NavigationUtils.getCurrentWorkspace() + "/" + formManipulator.getCurrentForm().getPagePath() + ".xhtml";
    System.err.print("Navigate to " + page);
    return page;
  }

  public String getPageType() {
    return "ListForm";
  }

  public GenericListForm getListForm() {
    return formManipulator.getListForm();
  }

  public GenericUpdateForm getUpdateForm() {
    return formManipulator.getUpdateForm();
  }

  public GenericForm getCurrentForm() {
    return formManipulator.getCurrentForm();
  }

  public Object getUpdateFormValue() {
    return getUpdateForm().getValue();
  }
//    public 

  public boolean isReady() {
    return formManipulator != null &&
            formManipulator.getCurrentForm() != null;
  }

  public void handleAction(String action) {
    if (navigationUtils.isFunctionNavigate(action))
      navigateTo(action);
    else {
        if (formManipulator == null) {
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No available actions"));
          return;
        }
        handleFormAction(action);
      }
  }

  public void handleFormAction(String action) {
    if(action != null && !action.isEmpty())
      try {
        formManipulator.handleAction(action);
      } catch (NoSuchMethodException e) {
        messageDialog.addMessage("Exception", "No_such_method", e.getMessage());
      }
  }

  public String getBlockerString() {
    return "PF('blocker').show()";
  }
}
