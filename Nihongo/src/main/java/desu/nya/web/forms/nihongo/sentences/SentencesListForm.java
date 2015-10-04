package desu.nya.web.forms.nihongo.sentences;

import desu.nya.server.entities.Sentences;
import desu.nya.web.forms.GenericListForm;
import desu.nya.web.forms.GenericModel;
import desu.nya.web.forms.ListMenu;

/**
 *
 * @author fess
 */
public class SentencesListForm extends GenericListForm<Sentences>{

  @Override
  public void initModel() {
    model.addColumn("Number", ".id");
    model.addColumn("Kanji", ".kanji");
    model.addColumn("Onyomi", ".onyomi");
    model.addColumn("Kunyomi", ".kunyomi");
    model.addColumn("Meaning", ".meaning");
    ListMenu list = new ListMenu(true);
    model.setMenu(list);
  }
}
