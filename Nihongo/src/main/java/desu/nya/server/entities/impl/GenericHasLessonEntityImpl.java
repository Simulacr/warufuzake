package desu.nya.server.entities.impl;

import desu.nya.server.entities.GenericBindEntity;
import desu.nya.server.entities.HasLessonEntity;
import desu.nya.server.entities.User;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

/**
 * User: Simulacr
 * Time: 29.12.14
 */
@MappedSuperclass
public class GenericHasLessonEntityImpl implements HasLessonEntity {
  @Id
  @GeneratedValue
  @Column(name = "id")
  @NotNull
  private Integer id;
  @Column(name = "lesson")
  private Integer lesson;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id=id;
  }

  public Integer getLesson() {
    return lesson;
  }

  public void setLesson(Integer lesson) {
    this.lesson = lesson;
  }
}
