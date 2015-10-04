package desu.nya.server.entities.impl;

import desu.nya.server.entities.GenericEntity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

/**
 * @author fess
 */
@MappedSuperclass
public class GenericEntityImpl implements GenericEntity {
  @Id
  @GeneratedValue
  @Column(name = "id")
  @NotNull
  private Integer id;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
}
