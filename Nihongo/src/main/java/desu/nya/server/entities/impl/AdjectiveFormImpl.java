package desu.nya.server.entities.impl;

import desu.nya.server.entities.AdjectiveForm;
import desu.nya.server.entities.Kotoba;
import desu.nya.server.entities.KotobaForm;

import javax.persistence.*;

/**
 * User: ievstratov
 * Date: 16.01.15
 */
@Entity
@Table(name = "ADJECTIVE_FORM", schema = "APP")
public class AdjectiveFormImpl extends GenericHasLessonEntityImpl implements AdjectiveForm {
  @Column(name = "defaultForm")
  private String defaultForm;
  @OneToOne(fetch= FetchType.EAGER)
  @JoinColumn(name="kotoba_id")
  private KotobaImpl kotoba;

  @Override
  public KotobaType getType() {
    return KotobaType.adjective;
  }

  public String getDefaultForm() {
    return defaultForm;
  }

  public void setDefaultForm(String defaultForm) {
    this.defaultForm = defaultForm;
  }

  public KotobaImpl getKotoba() {
    return kotoba;
  }

  public void setKotoba(Kotoba kotoba) {
    this.kotoba = (KotobaImpl)kotoba;
  }
}
