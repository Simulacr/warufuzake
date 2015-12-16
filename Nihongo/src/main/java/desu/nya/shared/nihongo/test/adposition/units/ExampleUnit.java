package desu.nya.shared.nihongo.test.adposition.units;

import org.primefaces.component.inputtext.InputText;

import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlOutputText;
import java.util.regex.Pattern;

/**
 * Created by Ker on 07.12.2015.
 */
public class ExampleUnit implements Unit {
    private String example;
  private InputText inputText;
  private HtmlOutputText label;

  @Override
  public String toString()
  {
    return example;
  }

  public ExampleUnit(String example, int width) {
        this.example = example;
    inputText = new InputText();
    inputText.setStyleClass(exampleClass);
    inputText.setStyleClass(styleClass);
    inputText.setDisabled(true);
    inputText.setValue(example);
    inputText.setStyle("width: " + width + "px");
    label = new HtmlOutputText();
    label.setEscape(false);
    label.setValue(example.
            replaceAll(Pattern.quote("["), "<ruby><rb>").
            replaceAll(";", "</rb><rp>(</rp><rt>").
            replaceAll(Pattern.quote("]"), "</rt><rp>)</rp></ruby>"));
    label.setStyle("width: " + width + "px");
    label.setStyleClass("ui-inputfield ui-inputtext ui-widget ui-state-default ui-corner-all ui-state-disabled kanjiTest");
    }

  @Override
  public UIComponent getComponent()
  {
    return label;
  }
}
