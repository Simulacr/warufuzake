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

  public MondaiUnit(String answer, int width)
  {
    this.answer = answer;
    inputText = new InputText();
    inputText.setStyleClass(styleClass);
    inputText.setRequired(true);
    inputText.setStyle("width: " + width + "px");
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
  public List<Unit> register(List<Unit> list)
  {
    list.add(this);
    inputText.setValueExpression("value", createValueExpression("#{navigation.updateForm.list[" + list.indexOf(this) + "]}", String.class));
    return list;
  }

  @Override
  public boolean validate(String asnwer)
  {
    boolean isValid = asnwer.equals(this.answer);
    inputText.setStyleClass(isValid ? "validMondai" : "invalidMondai");
    return isValid;
  }

  private ValueExpression createValueExpression(String valueExpression, Class<?> valueType) {
    FacesContext facesContext = FacesContext.getCurrentInstance();
    return facesContext.getApplication().getExpressionFactory().createValueExpression(
        facesContext.getELContext(), valueExpression, valueType);
  }
}
