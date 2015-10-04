package desu.nya.web.forms.nihongo.kotoba;

import desu.nya.server.entities.Kanji;
import desu.nya.server.entities.Kotoba;
import desu.nya.web.forms.GenericListForm;
import desu.nya.web.forms.GenericModel;

/**
 *
 * @author fess
 */
public class KotobaListForm extends GenericListForm<Kotoba>{

  public void initModel() {
    super.initModel();
    model.addColumn("Kanji", ".text", 40, GenericModel.Align.center);
    model.addColumn("Meaning", ".meaning", 100, GenericModel.Align.center);
    model.addColumn("Adjective", ".adjective", 60);
    model.addColumn("Verb", ".verb", 60);
    model.addColumn("Comment", ".comment");
    model.setBuilder(item -> item.isAdjective() ? "color: red" : item.isVerb() ? "color: green" : "");
  }
}
