package desu.nya.server.processors.technical;

import desu.nya.server.entities.User;
import desu.nya.server.entities.impl.UserImpl;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fess
 */
@Repository("loginService")
public class LoginProcessorImpl implements LoginProcessor{
    
    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private DataSource  dataSource;
 
    @Override
    @SuppressWarnings("unchecked")
    @Transactional
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException, DataAccessException {
        Object item = sessionFactory.getCurrentSession().createCriteria(UserImpl.class).
                add(Restrictions.eq("login", username)).uniqueResult();
        return (User)item;
    }
}
