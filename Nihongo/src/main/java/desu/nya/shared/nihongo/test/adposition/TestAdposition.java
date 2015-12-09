package desu.nya.shared.nihongo.test.adposition;

import desu.nya.server.entities.GenericEntity;
import desu.nya.server.entities.HasLessonEntity;
import desu.nya.server.entities.impl.GenericHasLessonEntityImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ker on 07.12.2015.
 */
public class TestAdposition implements HasLessonEntity {
    private List<AdpositionUnit> rei;
    private List<AdpositionUnit> mondai;
    private Integer lesson;
    private Integer id;

    public TestAdposition() {
        rei = Arrays.asList(new AdpositionUnit(true));
        mondai = Arrays.asList(new AdpositionUnit(false));
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public void setLesson(Integer lesson) {

    }

    @Override
    public Integer getLesson() {
        return null;
    }
}
