package desu.nya.web.forms.nihongo.kotoba;

import desu.nya.server.entities.Kotoba;
import desu.nya.services.nihongo.kotoba.KotobaService;
import desu.nya.shared.nihongo.KanaHelper;
import desu.nya.web.forms.Form;
import desu.nya.web.forms.GenericUpdateForm;
import desu.nya.web.forms.SpecialButton;
import desu.nya.web.utils.MessageDialog;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.outputlabel.OutputLabel;
import org.primefaces.component.panelgrid.PanelGrid;
import org.primefaces.component.selectbooleancheckbox.SelectBooleanCheckbox;

import javax.annotation.PostConstruct;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by ievstratov on 11.05.2015.
 */
@Form("kotoba/kotobaQuiz")
public class KotobaQuizForm extends GenericUpdateForm<Kotoba>{

  private Random random = new Random();
  private Kotoba randomKotoba;
  private List<Kotoba> lessonKotobas;
  private PanelGrid lessonPanel;
  private List<Boolean> selected;
  private Integer quizType;
  private Boolean quiz;
  private String answer;
  private List<String> answerList;
  private List<String> randomKanjiList = new ArrayList<>();
  private List<String> randomHiraganaList = new ArrayList<>();
  private List<String> allKanji;
  private Integer jiCount = 10;

  @Override
  public void initForm() {
    super.initForm();
    buildPanel();
    allKanji = ((KotobaService)service).getAllKanji();
  }

  @Override
  protected void initSpecialButtons() {
    addSpecialButton(SpecialButton.getCloseButton());
    addSpecialButton("Go", "go");
  }


  public void onChangeLessonList() {
    lessonKotobas = null;
    randomKotoba = null;
  }

  private void getLessonKotobas() {
    if(!selected.stream().anyMatch(Predicate.isEqual(true))) {
      getManipulator().getMessageDialog().addMessage("No lessons selected");
      return;
    }

    int maxLesson = -1;
    Set<Integer> lessons = new HashSet<>();
    for(int i=0; i<selected.size(); i++)
      if(selected.get(i)) {
        lessons.add(i + 1);
        if(i + 1 > maxLesson)
          maxLesson = i + 1;
      }

    lessonKotobas = ((KotobaService)service).getAllKotobaOfLessons(lessons);
    allKanji = ((KotobaService)service).getAllKanjiBeforeLesson(maxLesson);
    if(allKanji.isEmpty())
      getManipulator().getMessageDialog().addMessage("There are no kanji for these lessons");
  }

  public void onGo() {
    if(lessonKotobas == null)
      getLessonKotobas();

    next();
  }

  private void next() {
    if(lessonKotobas != null) {
      randomKotoba = lessonKotobas.get(random.nextInt(lessonKotobas.size()));
      randomHiraganaList = KanaHelper.instance().getRandomHiragana(jiCount);
      answer = "";
      randomizeKanji();
      Set<Integer> set = new HashSet<>();
      for(String k: randomKotoba.getText().split("")){
        int index = -1;
        while (index == -1 || set.contains(index))
          index = random.nextInt(jiCount);
        if(!KanaHelper.instance().isHiragana(k)) {
          randomKanjiList.remove(index);
          randomKanjiList.add(index, k);
        } else {
          randomHiraganaList.remove(index);
          randomHiraganaList.add(index, k);
        }
      }

    }
  }

  private void randomizeKanji() {
    randomKanjiList.clear();
    for (int i=0; i<10; i++)
      randomKanjiList.add(allKanji.get(random.nextInt(allKanji.size())));
  }

  public Kotoba getRandomKotoba() {
    System.err.print("Current kotoba: " + (randomKotoba == null ? "NULL" : randomKotoba.getText()));
    return randomKotoba;
  }

  public PanelGrid getLessonPanel() {
    return lessonPanel;
  }

  public void setLessonPanel(PanelGrid lessonPanel) {
    this.lessonPanel = lessonPanel;
  }

  private void buildPanel() {

    lessonPanel = new PanelGrid();
    PanelGrid mainPanel = new PanelGrid();
    lessonPanel.getChildren().add(mainPanel);
    mainPanel.setColumns(10);

    selected = new ArrayList<>();
    int lessonCount = ((KotobaService)service).getLastLessonNumber();
    PanelGrid childPanel = null;
    for(int i = 1; i <= lessonCount; i++) {
      SelectBooleanCheckbox checkbox = new SelectBooleanCheckbox();
      OutputLabel label = new OutputLabel();
      final int index = i - 1;
      if(index % 5 == 0){
        childPanel = new PanelGrid();
        childPanel.setColumns(2);
        mainPanel.getChildren().add(childPanel);
      }
      checkbox.setValue("#{currentForm.selected.get(" + index +  ")}");

      checkbox.addValueChangeListener((ValueChangeEvent valueChangeEvent) -> {
        selected.add(index, Boolean.valueOf(valueChangeEvent.getNewValue().toString()));
      });
      selected.add(false);
      label.setValue("#" + i);
      childPanel.getChildren().add(label);
      childPanel.getChildren().add(checkbox);
    }
  }


  public List<Boolean> getSelected() {
    return selected;
  }

  public void setSelected(List<Boolean> selected) {
    this.selected = selected;
  }

  public Integer getQuizType() {
    return quizType;
  }

  public void setQuizType(Integer quizType) {
    this.quizType = quizType;
  }

  public Boolean getQuiz() {
    return quiz;
  }

  public void setQuiz(Boolean quiz) {
    this.quiz = quiz;
  }

  public String getAnswer() {
    return answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }

  public void onAnswer() {
    if(!randomKotoba.getText().equals(answer))
      getManipulator().getMessageDialog().addMessage("Wrong_kanji");
    else
      next();
  }

  public void onRandomKanjiSelect(ActionEvent event) {
    answer += ((CommandButton)event.getSource()).getValue();
    if(randomKotoba.getText().equals(answer))
      next();
  }

  public void onBackspace(ActionEvent event) {
    answer = answer.length() > 1 ? answer.substring(0, answer.length() - 1) : "";
  }

  public void onDelete(ActionEvent event) {
    answer = "";
  }

  public List<String> getAnswerList() {
    return answerList;
  }

  public void setAnswerList(List<String> answerList) {
    this.answerList = answerList;
  }

  public List<String> getRandomKanjiList() {
    return randomKanjiList;
  }

  public void setRandomKanjiList(List<String> randomKanjiList) {
    this.randomKanjiList = randomKanjiList;
  }

  public List<String> getRandomHiraganaList() {
    return randomHiraganaList;
  }

  public void setRandomHiraganaList(List<String> randomHiraganaList) {
    this.randomHiraganaList = randomHiraganaList;
  }

  public Integer getJiCount() {
    return jiCount;
  }

  public void setJiCount(Integer jiCount) {
    if(jiCount < 4)
      this.jiCount = 3;
    else if(jiCount > 10)
      this.jiCount = 10;
    else
      this.jiCount = jiCount;
  }
}
