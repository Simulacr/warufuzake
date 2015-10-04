package desu.nya.web.forms;

import desu.nya.services.GenericService;

import java.io.Serializable;

/**
 *
 * @author fess
 * @param <E>
 * @param <T>
 */
public interface GenericForm<E> extends Serializable{
    void setPreviousForm(GenericForm form);
    
    String getPagePath();
    
    void setManipulator(GenericFormManipulator manipulator);

  void setService(GenericService<E> service);
}   
