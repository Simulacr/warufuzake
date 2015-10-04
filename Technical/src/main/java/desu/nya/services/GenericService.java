package desu.nya.services;

import java.util.List;

/**
 *
 * @author fess
 * @param <E>
 */
public interface GenericService<E> {
    E createNewEntity();
    
    void save(E entity);
    
    void removeList(List<E> list);

    void removeList(E[] list);
    
    List<E> getFullList();
}
