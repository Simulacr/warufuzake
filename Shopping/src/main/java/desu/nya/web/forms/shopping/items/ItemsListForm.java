package desu.nya.web.forms.shopping.items;

import desu.nya.server.entities.Item;
import desu.nya.web.forms.Form;
import desu.nya.web.forms.GenericListForm;
import desu.nya.web.forms.GenericModel;
import desu.nya.web.forms.ListMenu;

import java.util.List;

/**
 * @author fess
 */
@Form("shopping/items/itemList")
public class ItemsListForm extends GenericListForm {

  public ItemsListForm() {
    getMenu().addMenuItem(ListMenu.StandardMenuItem.ADD, ListMenu.StandardMenuItem.REFRESH,
        ListMenu.StandardMenuItem.REMOVE, ListMenu.StandardMenuItem.CLOSE);

  }

  public void initMenu() {
    model.addColumn("Name", ".name");
    model.addColumn("Price", ".price");
    model.addColumn("Unit", ".measuring$unit");
  }
}
