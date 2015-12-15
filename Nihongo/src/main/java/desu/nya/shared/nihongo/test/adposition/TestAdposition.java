package desu.nya.shared.nihongo.test.adposition;

import desu.nya.shared.nihongo.test.adposition.units.Unit;
import org.primefaces.component.panel.Panel;
import org.primefaces.component.tabview.Tab;
import org.primefaces.component.wizard.Wizard;

import javax.faces.component.html.HtmlOutputText;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ker on 07.12.2015.
 */
public class TestAdposition {
    private List<AdpositionUnit> rei = new ArrayList<>();
    private List<AdpositionUnit> mondai = new ArrayList<>();
  private int width = 10;

  public void addAdpositionUnit(String content, String type, String labelValue, Panel panel) {
    boolean isRei = "rei".equals(type) || "list".equals(type);
    AdpositionUnit adpositionUnit = new AdpositionUnit(content, width, type);
    if(isRei) {
      rei.add(adpositionUnit);
    }
    else {
      mondai.add(adpositionUnit);
    }
    HtmlOutputText label = new HtmlOutputText();
    label.setValue(labelValue);
    panel.getChildren().add(label);
    panel.getChildren().addAll(adpositionUnit.getComponents());
    panel.getChildren().add(getBR());
  }

    public TestAdposition(int width) {
      this.width = width;
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
