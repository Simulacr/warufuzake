package desu.nya.web.forms.nihongo.kanji;

import desu.nya.server.entities.Kanji;
import desu.nya.services.nihongo.kanji.KanjiService;
import desu.nya.web.forms.Form;
import desu.nya.web.forms.GenericUpdateForm;

/**
 *
 * @author fess
 */
@Form("kanji/update")
public class KanjiUpdateForm extends GenericUpdateForm<Kanji>{

  @Override
  protected void initNewValue() {
    super.initNewValue();
    item.setNumber(((KanjiFormManipulator)getManipulator()).getService().getLastNumber() + 1);
  }
}
