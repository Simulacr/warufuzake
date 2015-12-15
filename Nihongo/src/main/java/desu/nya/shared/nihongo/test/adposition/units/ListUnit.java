package desu.nya.shared.nihongo.test.adposition.units;

import org.primefaces.component.selectbooleanbutton.SelectBooleanButton;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

/**
 * Created by ievstratov on 15.12.2015.
 */
public class ListUnit implements Unit {

  private String content;
  private SelectBooleanButton btn;

  @Override
  public UIComponent getComponent()
  {
    return btn;
  }

  public ListUnit(String content, int num) {

    System.err.println(content);
    boolean checked = content.startsWith("-") && content.endsWith("-");
    if(checked)
      this.content = content.substring(1, content.length() - 2);
    btn = new SelectBooleanButton();
    btn.setLabel(this.content);
    btn.setDisabled(checked);
    btn.setValueExpression("", createValueExpression("#{navigation.updateForm.checked[" + num + "]}"));
    btn.setOffLabel(content.replaceAll("-", ""));
    btn.setOnLabel(content.replaceAll("-", ""));
    btn.setStyle("font-size: 13px");
    btn.setStyleClass("listUnit");
  }

  private ValueExpression createValueExpression(String valueExpression) {
    FacesContext facesContext = FacesContext.getCurrentInstance();
    return facesContext.getApplication().getExpressionFactory().createValueExpression(
        facesContext.getELContext(), valueExpression, String.class);
  }
}
