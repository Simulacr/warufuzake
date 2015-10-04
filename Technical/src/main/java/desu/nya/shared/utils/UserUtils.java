package desu.nya.shared.utils;

import desu.nya.server.entities.User;
import desu.nya.server.entities.Workspace;
import desu.nya.services.technical.WorkspaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.annotation.PostConstruct;


/**
 *
 * @author fess
 */
public class UserUtils {

  @Autowired
  private WorkspaceService workspaceService;

    //inner method
    public static User getCurrentUser()
    {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return (principal == null || principal instanceof String || principal.equals("guest") ? null : (User)principal);
    }

    public Workspace getDefaultWorkspace(){
      return workspaceService.getDefaultWorkspace();
    }

    public static String getWorkspaceString(){
      String result = "-";
      for(Workspace workspace : getCurrentUser().getWorkspaces())
        result += workspace.getName() + "-";
      return result.length() > 1 ? result.substring(1, result.length() - 1) : "";
    }

    public static boolean isAllowedWorkspace(String workspaceName){
      for(Workspace workspace : getCurrentUser().getWorkspaces())
        if(workspaceName.equals(workspace.getName()))
          return true;
      return false;
    }

    public static UserPreferences getCurrentPreferences(){
      User user = getCurrentUser();
      return user != null ? new UserPreferences(getCurrentUser()) : null;
    }
}
