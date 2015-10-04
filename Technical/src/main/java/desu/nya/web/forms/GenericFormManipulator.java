package desu.nya.web.forms;

import desu.nya.server.entities.GenericEntity;
import desu.nya.services.GenericService;
import desu.nya.shared.enums.FormType;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import desu.nya.shared.utils.Translator;
import desu.nya.web.utils.MessageDialog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;

import javax.annotation.PostConstruct;

/**
 * @param <T>
 * @author fess
 */
@Manipulator
public class GenericFormManipulator<E extends GenericEntity, T extends GenericService<E>> implements Serializable {
  private GenericListForm listForm;
  private GenericUpdateForm editForm;
  private T service;
  private FormType state = FormType.LIST;
  private final Class listFormClass;
  private final Class editFormClass;
  private final Class serviceClass;
  private boolean closed;
  @Autowired
  protected MessageDialog messageDialog;
  @Autowired
  protected Translator translator;

  public GenericFormManipulator(Class listFormClass, Class editFormClass, Class serviceClass) {
    this.listFormClass = listFormClass;
    this.editFormClass = editFormClass;
    this.serviceClass = serviceClass;
  }

  public GenericFormManipulator() {
    Manipulator config = getClass().getAnnotation(Manipulator.class);
    if(config == null)
      throw new IllegalArgumentException("Manipulator class should have generic signature or manipulator annotation");
    this.listFormClass = config.listForm();
    this.editFormClass = config.editForm();
    this.serviceClass = config.service();
  }

  @SuppressWarnings("unchecked")
  public void init(AutowireCapableBeanFactory factory) {
    try {
      service = (T) factory.createBean(Class.forName(serviceClass.getName() + "Impl"));
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    if (listFormClass != null) {
      listForm = (GenericListForm) factory.createBean(listFormClass);
      listForm.setManipulator(this);
      listForm.setService(service);
      listForm.initForm();
    }
    if (editFormClass != null) {
      editForm = (GenericUpdateForm) factory.createBean(editFormClass);
      editForm.setManipulator(this);
      editForm.setService(service);
      editForm.initForm();
      editForm.setTranslator(translator);
    }
  }

  public GenericForm handleAction(String action) throws NoSuchMethodException {
    Class clazz = state == FormType.LIST ? listFormClass : editFormClass;
    try {
      clazz.getMethod("on" + action.toUpperCase().charAt(0)
              + action.toLowerCase().substring(1)).invoke(getCurrentForm());
    } catch (InvocationTargetException | IllegalAccessException x) {
      x.printStackTrace();
    }
    return getCurrentForm();
  }

  public GenericListForm getListForm() {
    return listForm;
  }

  public GenericUpdateForm getUpdateForm() {
    return editForm;
  }

  @SuppressWarnings("unchecked")
  public void setUpdateFormValue(E value){
    editForm.setValue(value);
  }

  public GenericForm getCurrentForm() {
    return state == FormType.LIST ? getListForm() : getUpdateForm();
  }

  public void switchModeTo(FormType mode) {
    state = mode;
    if (getUpdateForm() != null)
      getUpdateForm().setNew(state == FormType.ADD);
  }

  public T getService() {
    return service;
  }

  public void close() {
    closed = true;
  }

  public boolean isClosed() {
    return closed;
  }

  public MessageDialog getMessageDialog() {
    return messageDialog;
  }

  public List<E> getFullList(){
    return service.getFullList();
  }
}
