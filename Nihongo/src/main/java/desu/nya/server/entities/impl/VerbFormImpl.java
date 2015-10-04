package desu.nya.server.entities.impl;

import desu.nya.server.entities.Kotoba;
import desu.nya.server.entities.VerbForm;

import javax.persistence.*;

/**
 * User: ievstratov
 * Date: 16.01.15
 */
@Entity
@Table(name = "VERB_FORM", schema = "APP")
public class VerbFormImpl extends GenericHasLessonEntityImpl implements VerbForm {

  @OneToOne
  @JoinColumn(name="kotoba_id")
  private KotobaImpl kotoba;
  @Column(name = "default")
  private String defaultForm;
  @Column(name = "masu")
  private String masuForm;
  @Column(name = "masita")
  private String masitaForm;
  @Column(name = "masen")
  private String masenForm;
  @Column(name = "masen_desita")
  private String masenDesitaForm;
  @Column(name = "nai")
  private String naiForm;
  @Column(name = "nakatta")
  private String nakattaForm;
  @Column(name = "ta")
  private String taForm;
  @Column(name = "te")
  private String teForm;

  public String getDefaultForm() {
    return defaultForm;
  }

  public void setDefaultForm(String defaultForm) {
    this.defaultForm = defaultForm;
  }

  public String getMasuForm() {
    return masuForm;
  }

  public void setMasuForm(String masuForm) {
    this.masuForm = masuForm;
  }

  public String getMasitaForm() {
    return masitaForm;
  }

  public void setMasitaForm(String masitaForm) {
    this.masitaForm = masitaForm;
  }

  public String getMasenForm() {
    return masenForm;
  }

  public void setMasenForm(String masenForm) {
    this.masenForm = masenForm;
  }

  public String getMasenDesitaForm() {
    return masenDesitaForm;
  }

  public void setMasenDesitaForm(String masenDesitaForm) {
    this.masenDesitaForm = masenDesitaForm;
  }

  public String getNaiForm() {
    return naiForm;
  }

  public void setNaiForm(String naiForm) {
    this.naiForm = naiForm;
  }

  public String getNakattaForm() {
    return nakattaForm;
  }

  public void setNakattaForm(String nakattaForm) {
    this.nakattaForm = nakattaForm;
  }

  public String getTaForm() {
    return taForm;
  }

  public void setTaForm(String taForm) {
    this.taForm = taForm;
  }

  public String getTeForm() {
    return teForm;
  }

  public void setTeForm(String teForm) {
    this.teForm = teForm;
  }

  @Override
  public KotobaType getType() {
    return KotobaType.verb;
  }

  public KotobaImpl getKotoba() {
    return kotoba;
  }

  public void setKotoba(Kotoba kotoba) {
    this.kotoba = (KotobaImpl)kotoba;
  }
}
