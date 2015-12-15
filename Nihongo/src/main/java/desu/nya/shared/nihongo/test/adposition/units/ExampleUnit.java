package desu.nya.shared.nihongo.test.adposition.units;

import org.primefaces.component.inputtext.InputText;

import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlOutputText;

/**
 * Created by Ker on 07.12.2015.
 */
public class ExampleUnit implements Unit {
    private String example;
  private InputText inputText;

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
    }

  @Override
  public UIComponent getComponent()
  {
    return inputText;
  }
}
