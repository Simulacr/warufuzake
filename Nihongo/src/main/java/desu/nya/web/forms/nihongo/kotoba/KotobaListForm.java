package desu.nya.web.forms.nihongo.kotoba;

import desu.nya.server.entities.Kotoba;
import desu.nya.shared.enums.FormType;
import desu.nya.web.forms.GenericModel;
import desu.nya.web.forms.nihongo.GenericHasLessonListForm;

/**
 *
 * @author fess
 */
public class KotobaListForm extends GenericHasLessonListForm<Kotoba> {

  public void initModel() {
    super.initModel();
    model.addColumn("Kanji", ".text", 60, GenericModel.Align.center);
    model.addColumn("Meaning", ".meaning", 200, GenericModel.Align.center);
    model.addColumn("Comment", ".comment");
    model.addColumn("Lesson", ".lesson");
    model.setBuilder(item -> item.isAdjective() ? "color: red" : "");
  }

  @Override
  protected void initMenu() {
    super.initMenu();
    menu.addMenuItem("Quiz", "Quiz", "quiz");
  }

  public void onQuiz() {
    getManipulator().switchModeTo(FormType.SIMPLE);
  }
}
