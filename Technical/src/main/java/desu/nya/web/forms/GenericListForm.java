package desu.nya.web.forms;

import desu.nya.server.entities.GenericEntity;
import desu.nya.services.GenericService;
import desu.nya.shared.enums.FormType;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @param <E>
 * @author fess
 */
public abstract class GenericListForm<E extends GenericEntity> implements GenericForm<E> {
  protected ListMenu menu;
  private GenericForm previousForm;
  private GenericFormManipulator manipulator;
  protected GenericModel<E> model;
  protected GenericService<E> service;

  @Override
  public void setService(GenericService<E> service) {
    this.service = service;
  }

  protected void initForm() {
    initMenu();
    initModel();
  }

  public ListMenu getMenu() {
    return menu;
  }

  protected void initMenu() {
    menu = new ListMenu(true);
  }

  protected void initModel() {
    model = new GenericModel<>();
    model.setMenu(menu);
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

  public GenericModel getModel() {
    updateModel();
    return model;
  }

  public void updateModel() {
    model.setWrappedData(getList());
  }

  public void onAdd() {
    manipulator.switchModeTo(FormType.ADD);
  }

  @SuppressWarnings("unchecked")
  public void onUpdate() {
    manipulator.switchModeTo(FormType.UPDATE);
    manipulator.setUpdateFormValue(model.getSelectedItem());
  }

  @SuppressWarnings("unchecked")
  public void onRemove() {
    manipulator.getService().removeList(model.getSelectedList());
    updateModel();
  }

  public void onRefresh() {
    updateModel();
  }

  public void onClose() {

  }

  @SuppressWarnings("unchecked")
  public <M extends GenericFormManipulator> M getManipulator() {
    return (M)manipulator;
  }

  @Override
  public String getPagePath() {
    Form config = getClass().getAnnotation(Form.class);
    if(config == null)
      return "genericList";
    return config.value();
  }

  public List<E> getList() {
    return manipulator.getFullList();
  }

  protected void initStandardMenu() {
    getMenu().addMenuItem(ListMenu.StandardMenuItem.ADD, ListMenu.StandardMenuItem.REFRESH,
        ListMenu.StandardMenuItem.REMOVE, ListMenu.StandardMenuItem.CLOSE);
  }
}
