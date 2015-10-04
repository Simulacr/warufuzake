package desu.nya.web.forms;

import desu.nya.services.GenericService;
import desu.nya.shared.enums.FormType;
import desu.nya.shared.utils.Translator;

import java.util.ArrayList;
import java.util.List;

/**
 * @param <E> type of item
 * @author fess
 */
public abstract class GenericUpdateForm<E> implements GenericForm<E> {
  protected E item;
  protected GenericService<E> service;
  private GenericForm previousForm;

  @Override
  public String getPagePath() {
    Form config = getClass().getAnnotation(Form.class);
    if(config == null)
      return "update";
    return config.value();
  }

  protected GenericFormManipulator manipulator;
  private List<SpecialButton> specialButtons = new ArrayList<SpecialButton>();
  private boolean isNew;
  private Translator translator;

  public GenericUpdateForm() {
  }

  public void initForm() {
    initSpecialButtons();
  }

  public void setService(GenericService service) {
    this.service = service;
  }

  public List<SpecialButton> getSpecialButtons() {
    return specialButtons;
  }

  public void addSpecialButton(String code, String action) {
    specialButtons.add(new SpecialButton(code, action, false));
  }

  public void addSpecialButton(SpecialButton button) {
    specialButtons.add(button);
  }

  public void onSave() {
    service.save(item);
    manipulator.getListForm().updateModel();
    onClose();
  }

  public void onClose() {
    if (manipulator.getListForm() != null)
      manipulator.switchModeTo(FormType.LIST);
  }

  protected void initSpecialButtons() {
    getSpecialButtons().add(SpecialButton.getCloseButton());
    getSpecialButtons().add(SpecialButton.getSaveButton());
  }

  public void setNew(boolean isNew) {
    this.isNew = isNew;
    if (isNew)
      initNewValue();
  }

  public boolean isNew() {
    return isNew;
  }

  protected void initNewValue() {
    item = (E) getManipulator().getService().createNewEntity();
  }


  public E getValue() {
    return item;
  }

  public void setValue(E value) {
    item = value;
  }

  @Override
  public void setPreviousForm(GenericForm form) {
    previousForm = form;
  }

  public GenericForm getPreviousForm() {
    return previousForm;
  }

  @Override
  public void setManipulator(GenericFormManipulator manipulator) {
    this.manipulator = manipulator;
  }

  public GenericFormManipulator getManipulator() {
    return manipulator;
  }

  public Translator getTranslator() {
    return translator;
  }

  public void setTranslator(Translator translator) {
    this.translator = translator;
  }
}
