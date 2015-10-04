package desu.nya.services.shopping;



import desu.nya.server.entities.Item;
import desu.nya.server.processors.shopping.ItemProcessor;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fess
 */
@Service("itemService")
public class ItemServiceImpl implements ItemService{
    
    @Autowired
    private ItemProcessor itemProcessor;

    @Override
    @Transactional
    public List<Item> getFullList() {
        return itemProcessor.getAllItem();
    }

    @Override
    public Item createNewEntity() {
        return itemProcessor.createNewItem();
    }

    @Override
    @Transactional
    public void save(Item entity) {
        itemProcessor.addItem(entity);
    }

    @Override
    public void removeList(List<Item> list) {
        itemProcessor.removeItems(list);
    }

    @Override
    public void removeList(Item[] array) {
      List<Item> list = new ArrayList<Item>();
      for(Item item:array)
        list.add(item);
      removeList(list);
    }
    
}
