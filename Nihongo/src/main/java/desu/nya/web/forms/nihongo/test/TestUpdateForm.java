package desu.nya.web.forms.nihongo.test;

import desu.nya.shared.nihongo.test.adposition.Test;
import desu.nya.web.forms.Form;
import desu.nya.web.forms.GenericUpdateForm;
import desu.nya.web.forms.SpecialButton;
import desu.nya.web.utils.MessageDialog;
import org.primefaces.event.FlowEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ker on 07.12.2015.
 */
@Form("test/go")
public class TestUpdateForm extends GenericUpdateForm<Test>  {
  private List<String> list = new ArrayList<>();
  private List<Boolean> checked = new ArrayList<>();
  @Override
  protected void initSpecialButtons()
  {
    getSpecialButtons().add(new SpecialButton("Validate", "validate", false));
    getSpecialButtons().add(new SpecialButton("Back", "close", true));
  }

  @Override
  public void setValue(Test value)
  {
    super.setValue(value);
    int questionSize = value.register();
    setTitle(getTranslator().getString("Lesson") + value.getLesson());
    for(int i = 0; i < questionSize; i++)
      list.add("");
  }

  public void onValidate() {
    if(getValue().validate(list))
      getManipulator().getMessageDialog().addMessage("Perfect!!");
  }


  private boolean lastTab;
  public String onFlowProcess(FlowEvent event) {
    lastTab = event.getNewStep() == null;
//    if(getValue().validate(list))
      return event.getNewStep();
//    else
//      return "confirm";
  }

  public List<String> getList()
  {
    return list;
  }

  public void setList(List<String> list)
  {
    this.list = list;
  }

  public boolean isLastTab()
  {
    return lastTab;
  }

  public void setLastTab(boolean lastTab)
  {
    this.lastTab = lastTab;
  }

  public List<Boolean> getChecked()
  {
    return checked;
  }

  public void setChecked(List<Boolean> checked)
  {
    this.checked = checked;
  }
}
