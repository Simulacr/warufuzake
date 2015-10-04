package desu.nya.web.forms.technical;

import desu.nya.services.technical.UserPreferencesService;
import desu.nya.services.technical.UserPreferencesServiceImpl;
import desu.nya.shared.enums.FormType;
import desu.nya.shared.utils.UserPreferences;
import desu.nya.web.forms.GenericFormManipulator;
import org.springframework.stereotype.Controller;


@Controller("userPreferences")
public class UserPreferenceManipulator extends GenericFormManipulator
{
  public UserPreferenceManipulator()
  {
    super(null, UserPreferenceUpdateForm.class, UserPreferencesServiceImpl.class);
    switchModeTo(FormType.UPDATE);
  }
}
