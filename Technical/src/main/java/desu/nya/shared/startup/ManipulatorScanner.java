package desu.nya.shared.startup;

import desu.nya.shared.utils.WorkspaceSet;
import desu.nya.web.forms.Manipulator;
import org.reflections.Reflections;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * User: ievstratov
 * Date: 25.11.14
 * Time: 12:53
 */
public class ManipulatorScanner implements InitializingBean{
  private final Map<String, WorkspaceSet> availableWs = new HashMap<>();
  private final List<String> workspaces = new ArrayList<>();

  @Override
  public void afterPropertiesSet() throws Exception {

  }

  @PostConstruct
  public void init(){

    //TODO
    workspaces.add("technical");
    workspaces.add("nihongo");
    workspaces.add("shopping");

    String manipulatorsLocation = "desu.nya.web.forms.";

    for (String workspace : workspaces){
      Reflections reflections = new Reflections(manipulatorsLocation + workspace);
      Set<Class<?>> forms = reflections.getTypesAnnotatedWith(Manipulator.class);
      WorkspaceSet workspaceSet = new WorkspaceSet(workspace);
      for (Class form : forms) {
        Manipulator manipulator = (Manipulator) form.getAnnotation(Manipulator.class);
        workspaceSet.addForm(manipulator.value(), form, manipulator.level());
      }
      availableWs.put(workspace, workspaceSet);
    }
  }

  public Map<String, WorkspaceSet> getAvailableWs(){
    return availableWs;
  }
}
