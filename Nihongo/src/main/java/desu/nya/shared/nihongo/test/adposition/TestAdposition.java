package desu.nya.shared.nihongo.test.adposition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ker on 07.12.2015.
 */
public class TestAdposition {
    private List<AdpositionUnit> rei;
    private List<AdpositionUnit> mondai;

    public TestAdposition() {
        rei = Arrays.asList(new AdpositionUnit(true));
        mondai = Arrays.asList(new AdpositionUnit(false));
    }
}
