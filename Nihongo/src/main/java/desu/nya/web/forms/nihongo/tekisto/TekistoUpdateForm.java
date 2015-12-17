package desu.nya.web.forms.nihongo.tekisto;

import desu.nya.server.entities.Tekisto;
import desu.nya.web.forms.Form;
import desu.nya.web.forms.GenericUpdateForm;
import desu.nya.web.forms.SpecialButton;

/**
 * User: fess
 * Date: 05.01.15
 */
@Form("tekisto/update")
public class TekistoUpdateForm extends GenericUpdateForm<Tekisto> {
  @Override
  protected void initSpecialButtons() {
    getSpecialButtons().add(SpecialButton.getCloseButton());
  }
}
