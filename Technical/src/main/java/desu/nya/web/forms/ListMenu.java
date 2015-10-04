package desu.nya.web.forms;

import org.hibernate.search.indexes.serialization.javaserialization.impl.Update;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fess
 */
public class ListMenu {
  private List<ListMenuItem> list = new ArrayList<ListMenuItem>();
  private Selector selector;

  public ListMenu() {

  }

  public ListMenu(boolean useStandardBtn) {
    if (useStandardBtn) {
      addMenuItem(StandardMenuItem.ADD);
      addMenuItem(StandardMenuItem.UPDATE);
      addMenuItem(StandardMenuItem.REFRESH);
      addMenuItem(StandardMenuItem.REMOVE);
    }
  }

  public void addMenuItem(ListMenuItem item) {
    list.add(item);
  }

  public ListMenu addMenuItem(String code, String action, String icon) {
    addMenuItem(new ListMenuItem(code, action, icon));
    return this;
  }

  public void addMenuItem(StandardMenuItem... items) {
    for (StandardMenuItem item : items)
      addMenuItem(new ListMenuItem(item.getCode(), item.toString(), item.getIcon()));
  }

  public List<ListMenuItem> getMenuItemList() {
    return list;
  }

  public Selector getSelector() {
    return selector;
  }

  public void setSelector(Selector selector) {
    this.selector = selector;
  }


  public class ListMenuItem {
    private String code;
    private String action;
    private String icon;

    public ListMenuItem(String code, String action,String icon) {
      this.code = code;
      this.action = action;
      this.icon = icon;
    }

    public String getCode() {
      return code;
    }

    public String getAction() {
      return action;
    }

    public String getIcon() {
      return icon;
    }
  }

  public enum StandardMenuItem {
    ADD("Add", "plustnick"),
    REMOVE("Remove", "trash"),
    CLOSE("Close", "close"),
    REFRESH("Refresh", "refresh"),
    VIEW("View", "sear"),
    UPDATE("Update", "disk");

    private String code;
    private String icon;

    private StandardMenuItem(String code, String icon) {
      this.code = code;
      this.icon = icon;
    }

    public String getCode() {
      return code;
    }

    public String getIcon() {
      return icon;
    }
  }

  public static class Selector<E> {
    private List<E> items;
    private String label;

    public Selector(List<E> items, String label) {
      this.items = items;
      this.label = label;
    }

    public List<E> getItems() {
      return items;
    }

    public String getLabel() {
      return label;
    }
  }

  private Command clickCommand;
  public <E>void onSelectorClick(E target) {
    clickCommand.execute(target);
  }

  public <E>void setClickCommand(Command<E> clickCommand) {
    this.clickCommand = clickCommand;
  }

  public interface Command<E> {
    void execute(E target);
  }
}
