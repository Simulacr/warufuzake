package desu.nya.web.forms.technical;

import desu.nya.shared.utils.UserPreferences;
import desu.nya.shared.utils.UserUtils;
import desu.nya.web.forms.Form;
import desu.nya.web.forms.GenericUpdateForm;
import desu.nya.web.utils.MessageDialog;


@Form("technical/preferencesUpdate")
public class UserPreferenceUpdateForm<T extends UserPreferences> extends GenericUpdateForm<T>
{
  @Override
  public T getValue() {
    return (T)UserUtils.getCurrentPreferences();
  }

  public void onSave(){
//      getManipulator().getService().savePreferences(item);
      getManipulator().getMessageDialog().addMessage("Please_relogin");
  }

  public void onClose(){
    getManipulator().close();
  }
}
