package desu.nya.shared.utils;

import desu.nya.shared.rights.AdminLevelType;
import desu.nya.shared.rights.AuthorityRole;
import desu.nya.web.forms.Manipulator;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * User: ievstratov
 * Date: 16.10.14
 * Time: 13:31
 */
public class WorkspaceSet {
  private String name;
  private Map<String, Pair> forms = new HashMap<>();
  public WorkspaceSet(String name){
    this.name = name;
  }

  public void addForm(String key, Class path, AuthorityRole role){
    forms.put(key, new Pair(path, role));
  }

  public Class getFormClass(String key){
    return forms.get(key).getClazz();
  }

  public AuthorityRole getRole(String key){
    return forms.get(key).getRole();
  }

  public boolean isFunction(String key, Collection<? extends GrantedAuthority> roles){
    if(!forms.containsKey(key))
      return false;

    boolean accessGranted = false;
    AuthorityRole levelType = forms.get(key).getRole();
    for (GrantedAuthority role: roles)
      if(levelType == role)
        accessGranted = true;
    if(!accessGranted)
      throw new AccessDeniedException("");
    return true;
  }

  public String getName() {
    return name;
  }

  private class Pair{
    private Class clazz;
    private AuthorityRole role;

    public Pair(Class clazz, AuthorityRole role){
      this.clazz = clazz;
      this.role = role;
    }

    private Class getClazz() {
      return clazz;
    }

    private AuthorityRole getRole() {
      return role;
    }
  }
}
