package desu.nya.services.technical;


import desu.nya.services.GenericService;
import desu.nya.shared.utils.UserPreferences;


public interface UserPreferencesService extends GenericService
{
  public void savePreferences(UserPreferences preferences);
}
