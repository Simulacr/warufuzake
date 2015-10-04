package desu.nya.shared.rights;

import java.util.ArrayList;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author fess
 */
public enum AuthorityRole implements GrantedAuthority{

    ROLE_USER, ROLE_ANONYMOUS, ROLE_ADMIN;

    @Override
    public String getAuthority() {
        return this.toString();
    }
    
    public static List<AuthorityRole> convertMaskToList(int mask)
    {
        List<AuthorityRole> resultList = new ArrayList<AuthorityRole>();
        //TODO mask to int converting
        switch(mask)
        {
            case 7: resultList.add(ROLE_ANONYMOUS);
            case 6: resultList.add(ROLE_USER);
            case 5: if(mask != 6) {resultList.add(ROLE_ANONYMOUS);};
            case 4: resultList.add(ROLE_ADMIN); break;     
            case 3:  resultList.add(ROLE_ANONYMOUS);   
            case 2:  resultList.add(ROLE_USER); break;  
            case 1:   resultList.add(ROLE_ANONYMOUS); 
            default:
        }
        
        return resultList;
    }
}
