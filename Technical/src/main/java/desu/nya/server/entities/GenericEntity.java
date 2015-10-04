package desu.nya.server.entities;

import java.io.Serializable;

/**
 * @author fess
 */
public interface GenericEntity extends Serializable {
  Integer getId();

  void setId(Integer id);
}
