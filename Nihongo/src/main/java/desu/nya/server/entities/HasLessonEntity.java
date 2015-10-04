package desu.nya.server.entities;

/**
 * User: ievstratov
 * Date: 08.01.15
 */
public interface HasLessonEntity extends GenericEntity {
  void setLesson(Integer lesson);

  Integer getLesson();
}
