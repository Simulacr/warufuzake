package desu.nya.web.forms.shopping.items;

import desu.nya.server.entities.Item;
import desu.nya.services.shopping.ItemService;
import desu.nya.services.shopping.ItemServiceImpl;
import desu.nya.web.forms.GenericFormManipulator;
import desu.nya.web.forms.Manipulator;
import org.springframework.stereotype.Controller;

/**
 *
 * @author fess
 */
@Controller
@Manipulator(value = "items", listForm = ItemsListForm.class, editForm = ItemsUpdateForm.class, service = ItemService.class)
public class ItemsFormManipulator extends GenericFormManipulator{
    
    public ItemsFormManipulator(){
        super(ItemsListForm.class, ItemsUpdateForm.class, ItemServiceImpl.class);
    }
    
}
