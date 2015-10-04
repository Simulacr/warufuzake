package desu.nya.server.entities;

/**
 * User: ievstratov
 * Date: 13.01.15
 */
public interface NihongoGroup extends GenericEntity{
  void setName(String name);
  String getName();

  void setURL(String url);
  String getURL();

}
