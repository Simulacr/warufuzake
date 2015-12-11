package desu.nya.shared.nihongo.test.adposition.units;

import javax.faces.component.UIComponent;
import java.util.List;

/**
 * Created by Ker on 07.12.2015.
 */
public interface Unit {
  UIComponent getComponent();

  default List<Unit> register(List<Unit> list) {
    return list;
  };

  default boolean validate(String answer) {
    return true;
  }
}
