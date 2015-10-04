package desu.nya.server.entities;

/**
 * User: ievstratov
 * Date: 16.01.15
 */
public interface VerbForm extends KotobaForm{

  String getTeForm();

  void setTeForm(String teForm);

  String getMasitaForm();

  void setMasitaForm(String masitaForm);

  String getMasuForm();

  void setMasuForm(String masuForm);

  String getTaForm();

  void setTaForm(String taForm);

  String getMasenForm();

  void setMasenForm(String masenForm);

  String getMasenDesitaForm();

  void setMasenDesitaForm(String masenDesitaForm);

  String getNaiForm();

  void setNaiForm(String naiForm);

  String getNakattaForm();

  void setNakattaForm(String nakattaForm);
}
