package desu.nya.server.entities.impl;

import desu.nya.shared.rights.AuthorityRole;
import desu.nya.server.entities.Locution;
import desu.nya.server.entities.User;
import desu.nya.server.entities.Workspace;

import java.util.Collection;
import java.util.Set;
import javax.persistence.*;


/**
 *
 * @author fess
 */
@Entity
@Table(name="USERS", schema="APP")
public class UserImpl extends GenericEntityImpl implements User{
  @Override
  public boolean equals(Object obj) {
    if(obj instanceof String)
      return false;
    UserImpl targetUser = (UserImpl)obj;
    if (targetUser == null)
      return false;
    return displayName != null && displayName.equals(targetUser.displayName);
  }

    @Column(name="login")
    private String login;
    @Column(name="display_name")
    private String displayName;
    @Column(name="mail")
    private String mail;
    @Column(name="enabled")
    private int enabled;
    @Column(name="key_id")
    private String key;
    @Column(name="authority_level")
    private int authorityLevel;
    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="locution_id")
    private LocutionImpl locution;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name="workspace_list", joinColumns = {
        @JoinColumn(name = "user_id", nullable = false, updatable = false) },
        inverseJoinColumns = { @JoinColumn(name = "workspace_id",
            nullable = false, updatable = false) })
    private Set<WorkspaceImpl> workspaces;
    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="default_workspace")
    private WorkspaceImpl defaultWorkspace;

    @Override
    public String getDisplayName() {
        return displayName;
    }

    @Override
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String getMail() {
        return mail;
    }

    @Override
    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public Collection<AuthorityRole> getAuthorities() {
        return AuthorityRole.convertMaskToList(authorityLevel);
    }

    @Override
    public String getPassword() {
        return key;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled == 1;
    }
    
    public int getEnabled()
    {
        return enabled;
    }
    
    public void setEnabled(int enabled)
    {
        this.enabled = enabled;
    }
    
    public int getAuthorityLevel()
    {
        return authorityLevel;
    }
    
    public void setAuthorityLevel(int level)
    {
        this.authorityLevel = level;
    }
    
    public String getKey()
    {
        return key;
    }
    
    public void setKey(String key)
    {
        this.key = key;
    }

    @Override
    public Locution getLocution() {
        return locution;
    }

    @Override
    public void setLocution(Locution locution) {
        this.locution = (LocutionImpl)locution;
    }


  @Override
  public Set getWorkspaces()
  {
    return workspaces;
  }


  public void setWorkspaces(Set workspaces)
  {
    this.workspaces = workspaces;
  }


  public WorkspaceImpl getDefaultWorkspace()
  {
    return defaultWorkspace;
  }


  public void setDefaultWorkspace(Workspace defaultWorkspace)
  {
    this.defaultWorkspace = (WorkspaceImpl)defaultWorkspace;
  }
}
