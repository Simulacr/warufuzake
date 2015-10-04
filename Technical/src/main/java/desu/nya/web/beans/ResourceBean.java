package desu.nya.web.beans;

import desu.nya.shared.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * @author fess
 */
@Controller("resources")
@Scope("request")
public class ResourceBean {

  private static final String DEFAULT_TYPE = ".png";

  @Autowired
  private UserUtils userUtils;

  public String getImagePath(String image){
    return getImagePath(image, null);
  }

  public String getImagePath(String image, String type){
    return "javax.faces.resource/img/" + image + (type == null ? DEFAULT_TYPE : "." + type) + "?ln=" + userUtils.getDefaultWorkspace().getName();
  }
}
