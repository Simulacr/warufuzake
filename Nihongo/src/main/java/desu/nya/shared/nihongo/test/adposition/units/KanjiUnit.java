package desu.nya.shared.nihongo.test.adposition.units;

import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlOutputText;
import java.util.regex.Pattern;

/**
 * Created by Ker on 07.12.2015.
 */
public class KanjiUnit implements Unit {
    private String kanji;
    private String furi;
  private HtmlOutputText label;

  @Override
  public String toString()
  {
    return "<ruby><rb>" + kanji + "</rb><rp>(</rp><rt>"  + furi + "</rt><rp>)</rp></ruby>";
  }

  public KanjiUnit(String mixed) {
    String[] temp = mixed.split(";");
    kanji = temp[0];
    furi = temp[1];
    label = new HtmlOutputText();
    label.setEscape(false);
    label.setValue(toString());
  }

  @Override
  public UIComponent getComponent()
  {
    return label;
  }
}
