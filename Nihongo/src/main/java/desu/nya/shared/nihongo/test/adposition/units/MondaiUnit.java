package desu.nya.shared.nihongo.test.adposition.units;

import org.primefaces.component.inputtext.InputText;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import java.util.List;

/**
 * Created by Ker on 07.12.2015.
 */
public class MondaiUnit implements Unit {
  private String answer;
  private InputText inputText;
  private InputText preview;

  public MondaiUnit(String answer, int width)
  {
    this.answer = answer;
    inputText = new InputText();
    inputText.setStyleClass(styleClass);
    inputText.setStyle("width: " + width + "px");
    preview = new InputText();
    preview.setStyleClass(styleClass);
    preview.setStyle("width: " + width + "px");
    preview.setReadonly(true);
  }

  @Override
  public String toString()
  {
    return answer;
  }

  @Override
  public UIComponent getComponent()
  {
    return inputText;
  }

  @Override
  public UIComponent getPreviewComponent()
  {
    return preview;
  }

  @Override
  public List<Unit> register(List<Unit> list)
  {
    list.add(this);
    inputText.setValueExpression("value", createValueExpression("#{navigation.updateForm.list[" + list.indexOf(this) + "]}"));
    preview.setValueExpression("value", createValueExpression("#{navigation.updateForm.list[" + list.indexOf(this) + "]}"));
    return list;
  }

  @Override
  public boolean validate(String asnwer)
  {
    boolean isValid = asnwer.equals(this.answer);
    inputText.setStyleClass(isValid ? "validMondai" : "invalidMondai");
    preview.setStyleClass(isValid ? "validMondai" : "invalidMondai");
    if(!isValid) {
      preview.setTitle(this.answer);
      inputText.setTitle(this.answer);
    }
    return isValid;
  }

  private ValueExpression createValueExpression(String valueExpression) {
    FacesContext facesContext = FacesContext.getCurrentInstance();
    return facesContext.getApplication().getExpressionFactory().createValueExpression(
        facesContext.getELContext(), valueExpression, String.class);
  }
}
