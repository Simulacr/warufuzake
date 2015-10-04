package desu.nya.web.forms.nihongo.tekisto;

import desu.nya.server.entities.Tekisto;
import desu.nya.web.forms.GenericListForm;
import desu.nya.web.forms.GenericModel;
import desu.nya.web.forms.ListMenu;

/**
 * User: fess
 * Date: 05.01.15
 */
public class TekistoListForm extends GenericListForm<Tekisto> {

  public void initModel() {
    super.initModel();
    model.addColumn("Lesson", ".lesson", 35);
    model.addColumn("Description", ".description");
  }
}
