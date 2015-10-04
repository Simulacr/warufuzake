package desu.nya.server.entities;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Set;


/**
 *
 * @author fess
 */
public interface User extends UserDetails, GenericEntity{
    String getDisplayName();
    void setDisplayName(String displayName);
    
    String getMail();
    void setMail(String mail);
    
    Locution getLocution();
    void setLocution(Locution locution);

    Set<Workspace> getWorkspaces();

    Workspace getDefaultWorkspace();
}
