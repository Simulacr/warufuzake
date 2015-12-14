package desu.nya.services.nihongo.test;

import desu.nya.shared.nihongo.test.adposition.AdpositionParser;
import desu.nya.shared.nihongo.test.adposition.Test;
import desu.nya.shared.nihongo.test.adposition.TestAdposition;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Ker on 08.12.2015.
 */
public class TestServiceImpl implements TestService {
    @Override
    public Test createNewEntity() {
        return null;
    }

    @Override
    public void save(Test entity) {

    }

    @Override
    public void removeList(List<Test> list) {

    }

    @Override
    public void removeList(Test[] list) {

    }

    @Override
    public List<Test> getFullList() {
        return Arrays.asList(AdpositionParser.getInstance().get(35));
    }
}
