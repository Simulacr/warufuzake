package desu.nya.server.processors.technical;

import desu.nya.server.entities.User;
import desu.nya.server.entities.impl.UserImpl;
import desu.nya.shared.utils.UserPreferences;
import desu.nya.shared.utils.UserUtils;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository("userPreferencesProcessor")
public class UserPreferencesProcessorImpl implements UserPreferencesProcessor
{
  @Autowired
  private SessionFactory sessionFactory;


  @Override
  @SuppressWarnings("unchecked")
  @Transactional
  public void savePreferences(UserPreferences userPreferences)
  {
    UserImpl loadedUser = (UserImpl) sessionFactory.getCurrentSession().load(UserImpl.class,
        UserUtils.getCurrentUser().getId());
    loadedUser.setDisplayName(userPreferences.getDisplayName());
    loadedUser.setDefaultWorkspace(userPreferences.getDefaultWorkspace());
    loadedUser.setLocution(userPreferences.getLocution());
    loadedUser.setKey(userPreferences.getPassword());
//    loadedUser.setWorkspaces(userPreferences.getWorkspaces());
    sessionFactory.getCurrentSession().update(loadedUser);
  }
}
