package desu.nya.server.entities;

/**
 * User: ievstratov
 * Date: 13.01.15
 */
public interface NihongoUser extends GenericEntity{
  void setGroup(NihongoGroup group);
  NihongoGroup getGroup();

  String getVKId();
  void setVKId(String vkId);

  String getName();
}
