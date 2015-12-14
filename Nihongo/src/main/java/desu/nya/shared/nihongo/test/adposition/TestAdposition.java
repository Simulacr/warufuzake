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
public class TestAdposition {
    private List<AdpositionUnit> rei = new ArrayList<>();
    private List<AdpositionUnit> mondai = new ArrayList<>();

  public void addAdpositionUnit(PanelGrid panel, String content, String type) {
    boolean isRei = "rei".equals(type);
    AdpositionUnit adpositionUnit = new AdpositionUnit(content, isRei);
    if(isRei) {
      rei.add(adpositionUnit);
    }
    else {
      mondai.add(adpositionUnit);
    }
    panel.getChildren().addAll(adpositionUnit.getComponents());
    panel.getChildren().add(getBR());
  }

    public TestAdposition() {

    }

  public int register(List<Unit> list) {
    list = new ArrayList<>();
    for(AdpositionUnit adpositionUnit: mondai)
      for(Unit unit: adpositionUnit.getUnits())
        unit.register(list);
    return list.size();
  }

  public List<AdpositionUnit> getMondai()
  {
    return mondai;
  }

  public List<AdpositionUnit> getRei()
  {
    return rei;
  }

  private HtmlOutputText getBR() {
    HtmlOutputText br = new HtmlOutputText();
    br.setEscape(false);
    br.setValue("<br/>");
    return br;
  }
}
