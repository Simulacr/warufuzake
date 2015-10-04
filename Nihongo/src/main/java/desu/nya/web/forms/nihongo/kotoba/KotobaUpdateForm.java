package desu.nya.web.forms.nihongo.kotoba;

import desu.nya.server.entities.Kanji;
import desu.nya.server.entities.Kotoba;
import desu.nya.web.forms.Form;
import desu.nya.web.forms.GenericUpdateForm;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fess
 */
@Form("kotoba/update")
public class KotobaUpdateForm extends GenericUpdateForm<Kotoba>{
  private String selectedForm;
  private static List<String> list = new ArrayList<>();
  static {
    list.add("None");
    list.add("Verb");
    list.add("Adjective");
  }

  public List<String> getKotobaFormList() {
    return list;
  }

  public void onSelectKotobaForm() {
    switch (selectedForm) {
      case "None":
    }
  }

  public String getSelectedForm() {
    return selectedForm;
  }

  public void setSelectedForm(String selectedForm) {
    this.selectedForm = selectedForm;
  }
}
