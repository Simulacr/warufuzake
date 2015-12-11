package desu.nya.shared.nihongo.test.adposition;

import desu.nya.shared.nihongo.test.adposition.units.*;

import javax.faces.component.UIComponent;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Ker on 07.12.2015.
 */
public class AdpositionUnit {
    private List<Unit> units;

    public AdpositionUnit(boolean rei) {
        if(rei) {
            units = Arrays.asList(new KanjiUnit("道", "みち"), new ExampleUnit("で"), new KanjiUnit("財布", "さいふ"),
                    new ExampleUnit("を"), new KanjiUnit("拾", "ひろ"), new HiraganaUnit("いました"));
        } else {
            units = Arrays.asList(new KanjiUnit("予定", "よてい"), new MondaiUnit("が"), new KanjiUnit("変", "か"), new HiraganaUnit("わったら"));
        }
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
