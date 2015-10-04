package desu.nya.server.processors.shopping;

import desu.nya.server.entities.Item;
import java.util.List;

/**
 *
 * @author fess
 */
public interface ItemProcessor {
    
    void addItem(Item item);
    
    List<Item> getAllItem();
    
    List<Item> getAllDrinks();
    
    List<Item> geAllFood();
    
    void removeItem(Item item);
    
    void removeItems(List<Item> list);
    
    Item createNewItem();
}
