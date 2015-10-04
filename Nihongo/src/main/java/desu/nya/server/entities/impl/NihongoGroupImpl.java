package desu.nya.server.entities.impl;

import desu.nya.server.entities.NihongoGroup;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * User: ievstratov
 * Date: 13.01.15
 */
@Entity
@Table(name = "NIHONGO_GROUP", schema = "APP")
public class NihongoGroupImpl extends GenericEntityImpl implements NihongoGroup{
  @Column(name="url")
  private String URL;
  @Column(name = "name")
  private String name;

  public String getURL() {
    return URL;
  }

  public void setURL(String URL) {
    this.URL = URL;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
