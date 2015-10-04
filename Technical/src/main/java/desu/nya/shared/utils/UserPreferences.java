package desu.nya.shared.utils;

import desu.nya.server.entities.Locution;
import desu.nya.server.entities.User;
import desu.nya.server.entities.Workspace;

import java.util.Set;


public class UserPreferences
{
  private String displayName;
  private String password;
  private Workspace defaultWorkspace;
  private Set<Workspace> workspaces;
  private String mail;
  private Locution locution;

  public UserPreferences(User user){
    displayName = user.getDisplayName();
    password = user.getPassword();
    defaultWorkspace = user.getDefaultWorkspace();
    workspaces = user.getWorkspaces();
    mail = user.getMail();
    locution = user.getLocution();
  }


  public String getDisplayName()
  {
    return displayName;
  }


  public void setDisplayName(String displayName)
  {
    this.displayName = displayName;
  }


  public String getPassword()
  {
    return password;
  }


  public void setPassword(String password)
  {
    this.password = password;
  }


  public Workspace getDefaultWorkspace()
  {
    return defaultWorkspace;
  }


  public void setDefaultWorkspace(Workspace defaultWorkspace)
  {
    this.defaultWorkspace = defaultWorkspace;
  }


  public Set<Workspace> getWorkspaces()
  {
    return workspaces;
  }


  public void setWorkspaces(Set<Workspace> workspaces)
  {
    this.workspaces = workspaces;
  }


  public Locution getLocution()
  {
    return locution;
  }


  public void setLocution(Locution locution)
  {
    this.locution = locution;
  }


  public String getMail()
  {
    return mail;
  }


  public void setMail(String mail)
  {
    this.mail = mail;
  }
}
