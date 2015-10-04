package desu.nya.server.entities;

/**
 * User: ievstratov
 * Date: 16.01.15
 */
public interface KotobaForm extends HasLessonEntity{

  enum KotobaType {verb, adjective}

  KotobaType getType();

  String getDefaultForm();

  void setDefaultForm(String defaultForm);

  Kotoba getKotoba();

  void setKotoba(Kotoba kotoba);
}
