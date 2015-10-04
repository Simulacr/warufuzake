package desu.nya.web.forms.nihongo.katakana;

import desu.nya.server.entities.Kanji;
import desu.nya.web.forms.Form;
import desu.nya.web.forms.GenericListForm;
import desu.nya.web.forms.GenericModel;
import desu.nya.web.forms.ListMenu;

/**
 *
 * @author fess
 */
@Form("katakana/list")
public class KatakanaListForm extends GenericListForm<Kanji>{

  public KatakanaListForm(){
    initStandardMenu();
  }

  @Override
  public void updateModel() {
    model = new GenericModel<>(getList());
    model.addColumn("Kanji", ".kanji");
    model.addColumn("Onyomi", ".onyomi");
    model.addColumn("Kunyomi", ".kunyomi");
    model.addColumn("Meaning", ".meaning");
    ListMenu list = new ListMenu(true);
    model.setMenu(list);
  }
}
