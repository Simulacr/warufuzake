package desu.nya.shared.nihongo.test.adposition;

import desu.nya.shared.nihongo.test.adposition.units.*;

import javax.faces.component.UIComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Ker on 07.12.2015.
 */
public class AdpositionUnit {
  private static final char K_OP = '[';
  private static final char K_ED = ']';
  private static final char Q_OP = '{';
  private static final char Q_ED = '}';

    private List<Unit> units;

    public AdpositionUnit(String content, int width, boolean rei) {
      //TODO validate
      int pos = 0;
      int k_beg = 0;
      int q_beg = 0;
      int h_beg = 0;
      char[] cont = content.toCharArray();
      units = new ArrayList<>();
      while (pos < content.length()) {
        switch (cont[pos]) {
          case K_OP:
            k_beg = pos;
            if(pos - 1 > h_beg)
              units.add(new HiraganaUnit(content.substring(h_beg + 1, pos)));
            break;
          case K_ED:
            units.add(new KanjiUnit(content.substring(k_beg + 1, pos)));
            h_beg = pos;
            break;
          case Q_OP:
            q_beg = pos;
            if(pos - 1 > h_beg)
              units.add(new HiraganaUnit(content.substring(h_beg + 1, pos)));
            break;
          case Q_ED:
            units.add(rei ?
                new ExampleUnit(content.substring(q_beg + 1, pos), width) :
                new MondaiUnit (content.substring(q_beg + 1, pos), width));
            h_beg = pos;
            break;
        }
        pos++;
      }
      if(pos - 1 > h_beg)
        units.add(new HiraganaUnit(content.substring(h_beg + 1, pos)));
    }

  public List<Unit> getUnits()
  {
    return units;
  }

  @Override
  public String toString()
  {
    return units.stream().map(Object::toString).collect(Collectors.joining());
  }

  public List<UIComponent> getComponents() {
    return units.stream().map(Unit::getComponent).collect(Collectors.toList());
  }
}
