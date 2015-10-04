package desu.nya.web.forms.nihongo.kotoba;

import desu.nya.server.entities.Kotoba;
import desu.nya.services.nihongo.kotoba.KotobaService;
import desu.nya.web.forms.Form;
import desu.nya.web.forms.GenericUpdateForm;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ievstratov on 11.05.2015.
 */
@Form("kotoba/kotobaQuiz")
public class KotobaQuizForm extends GenericUpdateForm<Kotoba>{

  private List<String> selectedLessons;
  private List<String> lessonList;

  @Override
  public void initForm() {
    super.initForm();
    lessonList = new ArrayList<>();
    int lessonCount = ((KotobaService)service).getLastLessonNumber();
    for(int i = 0; i < lessonCount; i++)
      lessonList.add("Lesson " + String.valueOf(i));

  }

  public List<String> getLessonList() {
    return lessonList;
  }

  public List<String> getSelectedLessons() {
    return selectedLessons;
  }

  public void setSelectedLessons(List<String> selectedLessons) {
    this.selectedLessons = selectedLessons;
  }
}
