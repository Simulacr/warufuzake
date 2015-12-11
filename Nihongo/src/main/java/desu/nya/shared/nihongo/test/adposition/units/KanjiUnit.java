package desu.nya.shared.nihongo.test.adposition.units;

import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlOutputText;

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

  public KanjiUnit(String kanji, String furi) {
        this.kanji = kanji;
        this.furi = furi;
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
