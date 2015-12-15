package desu.nya.shared.nihongo.test.adposition.units;

import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlOutputText;

/**
 * Created by Ker on 07.12.2015.
 */
public class HiraganaUnit implements Unit {
    private String hiragana;
  private HtmlOutputText label;

  @Override
  public String toString()
  {
    return hiragana;
  }

  public HiraganaUnit(String hiragana) {
        this.hiragana = hiragana;
    label = new HtmlOutputText();
//    label.setStyleClass(styleClass);
    label.setValue(hiragana);
    }

  @Override
  public UIComponent getComponent()
  {
    return label;
  }
}
