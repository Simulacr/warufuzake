package desu.nya.services.nihongo.test;

import desu.nya.shared.nihongo.test.adposition.TestAdposition;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Ker on 08.12.2015.
 */
public class TestServiceImpl implements TestService {
    @Override
    public TestAdposition createNewEntity() {
        return null;
    }

    @Override
    public void save(TestAdposition entity) {

    }

    @Override
    public void removeList(List<TestAdposition> list) {

    }

    @Override
    public void removeList(TestAdposition[] list) {

    }

    @Override
    public List<TestAdposition> getFullList() {
        return Arrays.asList(new TestAdposition());
    }
}
