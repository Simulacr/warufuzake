package desu.nya.web.beans;

import desu.nya.shared.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author fess
 */
@Controller("workspace")
@Scope("request")
public class WorkspaceBean{
  @Autowired
  private UserUtils userUtils;
    
  public String getTitle()
  {
    return userUtils.getDefaultWorkspace().getTitle();
  }

  public String getCurrentWorkspace()
  {
    return userUtils.getDefaultWorkspace().getName();
  }

  public List<String> getStyleSheets() {
    return Arrays.asList("common.css");
  }
}
