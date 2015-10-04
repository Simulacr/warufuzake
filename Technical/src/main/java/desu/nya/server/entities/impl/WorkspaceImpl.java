package desu.nya.server.entities.impl;

import desu.nya.server.entities.Workspace;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="WORKSPACE", schema="APP")
public class WorkspaceImpl extends GenericEntityImpl implements Workspace
{
  @Column(name="name")
  private String name;
  @Column(name="title")
  private String title;
  @Override
  public String getName()
  {
    return name;
  }


  public void setName(String name)
  {
    this.name = name;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }
}
