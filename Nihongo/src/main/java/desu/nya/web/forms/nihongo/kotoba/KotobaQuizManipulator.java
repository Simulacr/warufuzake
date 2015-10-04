package desu.nya.web.forms.nihongo.kotoba;

import desu.nya.server.entities.Kotoba;
import desu.nya.services.nihongo.kotoba.KotobaService;
import desu.nya.shared.enums.FormType;
import desu.nya.web.forms.GenericFormManipulator;
import desu.nya.web.forms.Manipulator;
import org.springframework.stereotype.Controller;

/**
 * Created by ievstratov on 11.05.2015.
 */
@Controller
@Manipulator(value = "kotobaQuiz", editForm = KotobaQuizForm.class, listForm = KotobaListForm.class, service = KotobaService.class)
public class KotobaQuizManipulator extends GenericFormManipulator<Kotoba, KotobaService> {

  public KotobaQuizManipulator() {
    switchModeTo(FormType.UPDATE);
  }
}
