package desu.nya.shared.nihongo.test.adposition.units;

import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlOutputText;

/**
 * Created by Ker on 07.12.2015.
 */
public class ExampleUnit implements Unit {
    private String example;
  private HtmlOutputText label;

  @Override
  public String toString()
  {
    return example;
  }

  public ExampleUnit(String example) {
        this.example = example;
    label = new HtmlOutputText();
    label.setValue(example);
    }

  @Override
  public UIComponent getComponent()
  {
    return label;
  }
}
