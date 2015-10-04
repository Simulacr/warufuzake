package desu.nya.server.processors.technical;

import desu.nya.server.entities.User;
import desu.nya.shared.utils.UserPreferences;


public interface UserPreferencesProcessor
{
  void savePreferences(UserPreferences userPreferences);
}
