package desu.nya.web.forms.shopping.items;

import desu.nya.server.entities.Item;
import desu.nya.services.shopping.ItemService;
import desu.nya.web.forms.Form;
import desu.nya.web.forms.GenericUpdateForm;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;


/**
 *
 * @author fess
 */
@Form("shopping/items/itemUpdate")
public class ItemsUpdateForm extends GenericUpdateForm<Item>{
}
