package desu.nya.web.forms.nihongo.user;

import desu.nya.shared.nihongo.user.NihongoUserPref;
import desu.nya.web.forms.Form;
import desu.nya.web.forms.technical.UserPreferenceUpdateForm;

/**
 * Created by ievstratov on 07.05.2015.
 */
@Form("nihongo/preferences")
public class NihongoUserPrefForm extends UserPreferenceUpdateForm<NihongoUserPref> {

  public NihongoUserPrefForm() {
    super();

  }
}
