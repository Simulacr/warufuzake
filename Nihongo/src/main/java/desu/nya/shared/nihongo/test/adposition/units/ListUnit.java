package desu.nya.shared.nihongo.test.adposition.units;

import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlOutputText;
import java.util.regex.Pattern;

/**
 * Created by ievstratov on 15.12.2015.
 */
public class ListUnit implements Unit {

  private String content;
//  private SelectBooleanButton btn;
private HtmlOutputText label;

  @Override
  public UIComponent getComponent()
  {
    return label;
  }

  public ListUnit(String content) {



    boolean checked = content.startsWith("-") && content.endsWith("-");
    this.content = checked ? content.substring(1, content.length() - 2) : content;
    this.content = this.content.
            replaceAll(Pattern.quote("["), "<ruby><rb>").
            replaceAll(";", "</rb><rp>(</rp><rt>").
            replaceAll(Pattern.quote("]"), "</rt><rp>)</rp></ruby>");
    label = new HtmlOutputText();
    label.setEscape(false);
    label.setValue(CONTROL.replace("%TEXT%", this.content).replace("%STYLE_CLASS%", checked ? " ui-state-disabled listUnit ui-state-active" : "")) ;
  }

  private static final String CONTROL = "<div class=\"ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only　%STYLE_CLASS%\" " +
          "style=\"padding: 0 10px;margin: 0 2px\" onclick=\"checkTestVariant(this)\">"+
  "<span class=\"ui-button-text ui-c\" style=\"padding-top:8px\">%TEXT%</span></div>";
}
