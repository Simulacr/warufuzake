package desu.nya.services.nihongo;

import desu.nya.server.entities.HasLessonEntity;
import desu.nya.services.GenericService;

import java.util.List;

/**
 * Created by Ker on 26/10/2015.
 */
public interface GenericLessonService<E extends HasLessonEntity> extends GenericService<E> {
    Integer getLastLessonNumber();

    List<E> getListOfLesson(int lesson);
}
