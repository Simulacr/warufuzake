package desu.nya.shared.nihongo.test.adposition;

import desu.nya.shared.nihongo.test.adposition.units.ExampleUnit;
import desu.nya.shared.nihongo.test.adposition.units.HiraganaUnit;
import desu.nya.shared.nihongo.test.adposition.units.KanjiUnit;
import desu.nya.shared.nihongo.test.adposition.units.Unit;

import java.util.Arrays;
import java.util.List;

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
            units = Arrays.asList(new KanjiUnit("予定", "よてい"), new ExampleUnit("が"), new KanjiUnit("変", "か"), new HiraganaUnit("わったら"));
        }
    }
}
