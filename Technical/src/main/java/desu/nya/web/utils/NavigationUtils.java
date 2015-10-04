package desu.nya.web.utils;

import desu.nya.shared.exceptions.FunctionalException;
import desu.nya.shared.startup.ManipulatorScanner;
import desu.nya.shared.utils.UserUtils;
import desu.nya.shared.utils.WorkspaceSet;
import desu.nya.web.forms.GenericFormManipulator;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;

import javax.annotation.PostConstruct;

/**
 * @author fess
 */
public class NavigationUtils {
  private static String currentWorkspace;
  private static Map<String, WorkspaceSet> availableWs;
  @Autowired
  private ManipulatorScanner manipulatorScanner;

  @PostConstruct
  private void init() {
    currentWorkspace = "nihongo";
  }

  public static String getCurrentWorkspace(){
    return currentWorkspace;
  }

  public static void switchWorkspace(String currentWorkspace) {

    if (!currentWorkspace.equals(NavigationUtils.currentWorkspace) || currentWorkspace.isEmpty()) {
      if (UserUtils.isAllowedWorkspace(currentWorkspace))
        NavigationUtils.currentWorkspace = currentWorkspace;
    }
  }

  public GenericFormManipulator createManipulator(String key, AutowireCapableBeanFactory factory) throws
      FunctionalException {
    if(availableWs == null)
      availableWs = manipulatorScanner.getAvailableWs();
    try {
      GenericFormManipulator form =
          (GenericFormManipulator) factory.createBean(availableWs.get(currentWorkspace).getFormClass(key));
      form.init(factory);
      return form;
    } catch (Exception ex) {
      ex.printStackTrace();
      throw new FunctionalException("Manipulator_creation_failed_сause", ex.getMessage());
    }
  }

  public boolean isFunctionNavigate(String page) {
    if(availableWs == null)
      availableWs = manipulatorScanner.getAvailableWs();
    return availableWs.get(currentWorkspace).isFunction(page, UserUtils.getCurrentUser().getAuthorities());
  }

}
