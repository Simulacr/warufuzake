package desu.nya.services.technical;

import desu.nya.server.entities.User;
import desu.nya.server.processors.technical.UserPreferencesProcessor;
import desu.nya.shared.utils.UserPreferences;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("userPreferencesService")
public class UserPreferencesServiceImpl implements UserPreferencesService
{
  @Autowired
  private UserPreferencesProcessor userPreferencesProcessor;


  @Override
  public void savePreferences(UserPreferences userPreferences)
  {
    userPreferencesProcessor.savePreferences(userPreferences);
  }


  @Override
  public Object createNewEntity()
  {
    throw new UnsupportedOperationException("Doesnt support");
  }


  @Override
  public void save(Object entity)
  {
    throw new UnsupportedOperationException("Doesnt support");
  }


  @Override
  public void removeList(List list)
  {
    throw new UnsupportedOperationException("Doesnt support");
  }


  @Override
  public void removeList(Object[] list)
  {
    throw new UnsupportedOperationException("Doesnt support");
  }


  @Override
  public List getFullList()
  {
    throw new UnsupportedOperationException("Doesnt support");
  }
}
