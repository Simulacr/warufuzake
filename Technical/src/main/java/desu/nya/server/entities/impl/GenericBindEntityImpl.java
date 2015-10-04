package desu.nya.server.entities.impl;

import desu.nya.server.entities.GenericBindEntity;
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
public class GenericBindEntityImpl implements GenericBindEntity {
  @Id
  @GeneratedValue
  @Column(name = "id")
  @NotNull
  private Integer id;
  @Column(name = "seggregation_id")
  private Integer userId;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id=id;
  }

  @Override
  public void bind(User user) {
    userId = user.getId();
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }
}
