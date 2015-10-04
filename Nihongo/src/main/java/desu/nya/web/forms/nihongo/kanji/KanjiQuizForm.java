package desu.nya.web.forms.nihongo.kanji;

import desu.nya.server.entities.Kanji;
import desu.nya.services.GenericService;
import desu.nya.services.nihongo.kanji.KanjiService;
import desu.nya.web.forms.Form;
import desu.nya.web.forms.GenericForm;
import desu.nya.web.forms.GenericFormManipulator;
import desu.nya.web.forms.GenericUpdateForm;

/**
 * User: Simulacr
 * Time: 11.07.2015
 */
@Form("kanji/quiz")
public class KanjiQuizForm implements GenericForm<Kanji> {
  private KanjiFormManipulator manipulator;
  private KanjiService service;
  @Override
  public void setPreviousForm(GenericForm form) {

  }

  @Override
  public String getPagePath() {
    return "kanji/quiz";
  }

  @Override
  public void setManipulator(GenericFormManipulator manipulator) {
    this.manipulator = (KanjiFormManipulator)manipulator;
  }

  @Override
  public void setService(GenericService<Kanji> service) {
    this.service = (KanjiService) service;
  }
}
