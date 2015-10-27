package desu.nya.web.forms.nihongo.kanji;

import desu.nya.server.entities.Kanji;
import desu.nya.web.forms.GenericListForm;
import desu.nya.web.forms.GenericModel;
import desu.nya.web.forms.ListMenu;
import desu.nya.web.forms.nihongo.GenericHasLessonListForm;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fess
 */
public class KanjiListForm extends GenericHasLessonListForm<Kanji> {
  private List<Kanji> filteredList = null;

  @Override
  public GenericModel getModel() {
    model.setWrappedData(filteredList == null || filteredList.isEmpty() ? getList() : filteredList);
    return model;
  }

  @Override
  protected void initMenu() {
    super.initMenu();
    menu.addMenuItem("Quiz", "Quiz", "search");
  }

  public void initModel() {
    super.initModel();
    model.addColumn("Number", ".number", 40, GenericModel.Align.center);
    model.addColumn("Lesson", ".lesson", 35, GenericModel.Align.center);
    model.addColumn("Kanji", ".kanji", 40, GenericModel.Align.center);
    model.addColumn("Onyomi", ".onyomi");
    model.addColumn("Kunyomi", ".kunyomi");
    model.addColumn("Meaning", ".meaning");
  }

  public void onQuiz() {
    getKanjiManipulator().showQuizForm();
  }

  public KanjiFormManipulator getKanjiManipulator() {
    return (KanjiFormManipulator)getManipulator();
  }
}
