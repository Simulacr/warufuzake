package desu.nya.web.forms;

import desu.nya.server.entities.GenericEntity;
import org.primefaces.model.SelectableDataModel;

import javax.faces.model.ListDataModel;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author fess
 */
public class GenericModel<E extends GenericEntity> extends ListDataModel<E> implements SelectableDataModel<E> {
  private List<ModelColumn> columns = new ArrayList<>();
  private E[] selectedList;
  private ListMenu menu;
  private StyleBuilder<E> builder;

  public GenericModel(List<E> data) {
    super(data);
    init();
  }

  public GenericModel() {
  }


  @Override
  public Object getRowKey(E value) {
    return value.getId();
  }


  @Override
  public E getRowData(String rowKey) {
    List<E> list = (List<E>) getWrappedData();
    for (E item : list) {
      if (item.getId() == Integer.parseInt(rowKey))
        return item;
    }
    return null;
  }

  public E[] getSelectedList() {
    return selectedList;
  }

  public void setSelectedList(E[] list) {
    this.selectedList = list;
  }

  public E getSelectedItem(){
    return selectedList.length == 1 ? selectedList[0] : null;
  }

  public enum Align {center, left, right, justify}

  public interface StyleBuilder<E> {
    String get(E item);
  }

  public class ModelColumn {
    private String header;
    private String field;
    private int width = -1;
    private Align align;

    public ModelColumn(String header, String field) {
      this.header = header;
      this.field = field;
    }

    public ModelColumn(String header, String field, int width) {
      this.header = header;
      this.field = field;
      this.width = width;
    }

    public ModelColumn(String header, String field, int width, Align align) {
      this.header = header;
      this.field = field;
      this.width = width;
      this.align = align;
    }

    public String getHeader() {
      return header;
    }

    public String getField() {
      return field;
    }

    public String styleAt(E item) {
      return builder == null || builder.get(item) == null ? "" : builder.get(item);
    }

    public Object valueAt(E item) {
      try {
        int ampPos = field.indexOf("$");
        if (ampPos == -1) {
          Method method;
          try {
            method = item.getClass().getMethod("get" + field.toUpperCase()
                    .charAt(1) + field.substring(2));
          } catch (NoSuchMethodException ex) {
            method = item.getClass().getMethod("is" + field.toUpperCase()
                    .charAt(1) + field.substring(2));
          }
          return method.invoke(item);
        } else {
          Object rec = item.getClass().getMethod("get" + field.toUpperCase()
              .charAt(1) + field.substring(2, ampPos)).invoke(item);
          if (rec == null) {
            return null;
          }
          return rec.getClass().getMethod("get" + field.toUpperCase()
              .charAt(ampPos + 1) + field.substring(ampPos + 2)).invoke(rec);
        }
      } catch (Exception ignored) {
        ignored.printStackTrace();
      }
      return field;
    }

    public int getWidth() {
      return width;
    }

    public void setWidth(int width) {
      this.width = width;
    }

    public String getStyleAlign() {
      return align == null ? null : "text-align:" + align.toString();
    }
  }

  public void setBuilder(StyleBuilder<E> builder) {
    this.builder = builder;
  }

  public List<ModelColumn> getModelColumns() {
    return columns;
  }

  public void addColumn(ModelColumn column) {
    columns.add(column);
  }

  public void addColumn(String header, String field) {
    columns.add(new ModelColumn(header, field));
  }

  public void addColumn(String header, String field, int width) {
    columns.add(new ModelColumn(header, field, width));
  }

  public void addColumn(String header, String field, int width, Align align) {
    columns.add(new ModelColumn(header, field, width, align));
  }

  protected void init() {

  }


  public void setMenu(ListMenu menu){
    this.menu = menu;
  }

  public ListMenu getMenu(){
    return menu;
  }
}
