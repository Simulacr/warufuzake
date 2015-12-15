package desu.nya.shared.nihongo.test.adposition;

import desu.nya.server.entities.HasLessonEntity;
import desu.nya.shared.nihongo.test.adposition.units.Unit;
import org.primefaces.component.panelgrid.PanelGrid;
import org.primefaces.component.wizard.Wizard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ievstratov on 14.12.2015.
 */
public class Test implements HasLessonEntity {
  private Integer lesson;
  private Integer id;
  private List<TestAdposition> tests;
  private List<Unit> list;
  private Wizard panel;

  public Test(Integer id, Integer lesson)
  {
    this.id = id;
    this.lesson = lesson;
    tests = new ArrayList<>();
    panel = new Wizard();
  }

  @Override
  public Integer getId() {
    return id;
  }

  @Override
  public void setId(Integer id) {
    this.id = id;
  }

  @Override
  public void setLesson(Integer lesson) {
    this.lesson = lesson;
  }

  @Override
  public Integer getLesson() {
    return lesson;
  }

  public List<TestAdposition> getTests()
  {
    return tests;
  }

  public void setTests(List<TestAdposition> tests)
  {
    this.tests = tests;
  }

  public void addTest(TestAdposition test) {
    tests.add(test);
  }

  public int register() {
    list = new ArrayList<>();
    for(TestAdposition adposition: tests)
      for(AdpositionUnit adpositionUnit: adposition.getMondai())
        for(Unit unit: adpositionUnit.getUnits())
          unit.register(list);
    return list.size();
  }

  public boolean validate(List<String> answerList) {
    boolean isAllValid = true;
    for (int i = 0; i < answerList.size(); i++) {
      String answer = answerList.get(i);
      isAllValid &= list.get(i).validate(answer);
    }
    return isAllValid;
  }

  public Wizard getPanel()
  {
    return panel;
  }

  public void setPanel(Wizard panel)
  {
    this.panel = panel;
  }
}
