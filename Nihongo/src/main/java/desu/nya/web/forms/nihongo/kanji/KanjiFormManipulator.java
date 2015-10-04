package desu.nya.web.forms.nihongo.kanji;

import desu.nya.server.entities.Kanji;
import desu.nya.services.nihongo.kanji.KanjiService;
import desu.nya.web.forms.GenericForm;
import desu.nya.web.forms.GenericFormManipulator;
import desu.nya.web.forms.Manipulator;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.stereotype.Controller;

/**
 *
 * @author fess
 */
@Controller
@Manipulator(value = "kanji", editForm = KanjiUpdateForm.class, listForm = KanjiListForm.class, service = KanjiService.class)
public class KanjiFormManipulator  extends GenericFormManipulator<Kanji, KanjiService>{
  private KanjiQuizForm quizForm;
  private boolean showQuiz;

  @Override
  public void init(AutowireCapableBeanFactory factory) {
    super.init(factory);
    quizForm = new KanjiQuizForm();
    quizForm.setManipulator(this);
    quizForm.setService(getService());
  }

  public void showQuizForm() {
    showQuiz = true;
  }

  @Override
  public GenericForm getCurrentForm() {
    return showQuiz ? quizForm : super.getCurrentForm();
  }
}
