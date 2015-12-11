package desu.nya.shared.nihongo.test.adposition;

import desu.nya.server.entities.GenericEntity;
import desu.nya.server.entities.HasLessonEntity;
import desu.nya.server.entities.impl.GenericHasLessonEntityImpl;
import desu.nya.shared.nihongo.test.adposition.units.Unit;
import org.primefaces.component.panelgrid.PanelGrid;

import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlOutputText;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ker on 07.12.2015.
 */
public class TestAdposition implements HasLessonEntity {
    private List<AdpositionUnit> rei;
    private List<AdpositionUnit> mondai;
    private Integer lesson = 35;
    private Integer id = 35;
    private PanelGrid panel;
    private List<Unit> list;

    public TestAdposition() {
        rei = Arrays.asList(new AdpositionUnit(true));
        mondai = Arrays.asList(new AdpositionUnit(false));
      panel = new PanelGrid();
      for(AdpositionUnit unit: rei) {
        panel.getChildren().addAll(unit.getComponents());
        panel.getChildren().add(getBR());
      }
      for(AdpositionUnit unit: mondai) {
        panel.getChildren().addAll(unit.getComponents());
        panel.getChildren().add(getBR());
      }
    }

  public int register() {
    list = new ArrayList<>();
    for(AdpositionUnit adpositionUnit: mondai)
      for(Unit unit: adpositionUnit.getUnits())
        unit.register(list);
    return list.size();
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

    }

    @Override
    public Integer getLesson() {
        return null;
    }

  public List<AdpositionUnit> getMondai()
  {
    return mondai;
  }

  public List<AdpositionUnit> getRei()
  {
    return rei;
  }

  public PanelGrid getPanel()
  {
    return panel;
  }

  public void setPanel(PanelGrid panel)
  {
    this.panel = panel;
  }

  public boolean validate(List<String> answerList) {
    boolean isAllValid = true;
    for (int i = 0; i < answerList.size(); i++) {
      String answer = answerList.get(i);
      isAllValid &= list.get(i).validate(answer);
    }
    return isAllValid;
  }

  private HtmlOutputText getBR() {
    HtmlOutputText br = new HtmlOutputText();
    br.setEscape(false);
    br.setValue("<br/");
    return br;
  }
}
