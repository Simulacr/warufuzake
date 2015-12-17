package desu.nya.shared.nihongo.test.adposition;

import org.primefaces.component.outputpanel.OutputPanel;
import org.primefaces.component.panelgrid.PanelGrid;

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

  public void addAdpositionUnit(String content, String type, String labelValue, PanelGrid panel) {
    boolean isRei = "rei".equals(type) || "list".equals(type);
    AdpositionUnit adpositionUnit = new AdpositionUnit(content, width, type);
    if(isRei) {
      rei.add(adpositionUnit);
    }
    else {
      mondai.add(adpositionUnit);
    }
    HtmlOutputText label = new HtmlOutputText();
    OutputPanel contentPanel = new OutputPanel();
    label.setValue(labelValue == null ? "" : labelValue);
    panel.getChildren().add(label);
    contentPanel.getChildren().addAll(adpositionUnit.getComponents());
    contentPanel.setStyle("border: 0");
    panel.getChildren().add(contentPanel);
  }

    public TestAdposition(int width) {
      this.width = width;
    }

  public List<AdpositionUnit> getMondai()
  {
    return mondai;
  }

  public List<AdpositionUnit> getRei()
  {
    return rei;
  }
}
