package desu.nya.web.forms.nihongo.test;

import desu.nya.shared.nihongo.test.adposition.TestAdposition;
import desu.nya.web.forms.Form;
import desu.nya.web.forms.GenericUpdateForm;
import desu.nya.web.forms.SpecialButton;
import desu.nya.web.utils.MessageDialog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ker on 07.12.2015.
 */
@Form("test/go")
public class TestUpdateForm extends GenericUpdateForm<TestAdposition>  {
  private List<String> list = new ArrayList<>();
  @Override
  protected void initSpecialButtons()
  {
    getSpecialButtons().add(new SpecialButton("Validate", "validate", false));
  }

  @Override
  public void setValue(TestAdposition value)
  {
    super.setValue(value);
    int questionSize = value.register();
    for(int i = 0; i < questionSize; i++)
      list.add("");
  }

  public void onValidate() {
    if(getValue().validate(list))
      getManipulator().getMessageDialog().addMessage("Perfect!!");
  }

  public List<String> getList()
  {
    return list;
  }

  public void setList(List<String> list)
  {
    this.list = list;
  }
}
