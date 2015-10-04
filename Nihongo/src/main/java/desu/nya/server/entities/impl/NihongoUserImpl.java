package desu.nya.server.entities.impl;

import desu.nya.server.entities.NihongoGroup;
import desu.nya.server.entities.NihongoUser;

import javax.persistence.*;

/**
 * User: ievstratov
 * Date: 13.01.15
 */
@Entity
@Table(name = "NIHONGO_USER", schema = "APP")
public class NihongoUserImpl extends GenericEntityImpl implements NihongoUser{
  @ManyToOne(fetch= FetchType.EAGER)
  @JoinColumn(name="group_id")
  private NihongoGroupImpl group;
  @OneToOne
  @JoinColumn(name = "user")
  private UserImpl user;
  @Column
  private String VKId;

  public NihongoGroup getGroup() {
    return group;
  }

  public void setGroup(NihongoGroup group) {
    this.group = (NihongoGroupImpl)group;
  }

  public String getVKId() {
    return VKId;
  }

  public void setVKId(String VKId) {
    this.VKId = VKId;
  }

  public String getName() {
    return user.getDisplayName();
  }
}
