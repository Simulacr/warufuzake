package desu.nya.server.entities.impl;

import desu.nya.server.entities.Kanji;
import desu.nya.server.entities.Kotoba;
import desu.nya.server.entities.KotobaForm;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * @author fess
 */
@Entity
@Table(name = "KOTOBA", schema = "APP")
public class KotobaImpl extends GenericHasLessonEntityImpl implements Kotoba {

  @Column(name="text")
  private String text;
  @Column(name = "kana")
  private String kana;
  @Column(name = "meaning")
  private String meaning;
  @Column(name = "comment")
  private String comment;
  @OneToOne(fetch= FetchType.EAGER)
  @JoinColumn(name="adjective_id")
  private AdjectiveFormImpl adjectiveForm;
  @ManyToMany(fetch= FetchType.EAGER)
  @JoinTable(name = "kotoba_kanji", joinColumns = {
          @JoinColumn(name = "kotoba_id", nullable = true, updatable = false)
  }, inverseJoinColumns = {@JoinColumn(name = "kanji_id", nullable = true, updatable = false)})
  private Set<KanjiImpl> kanjis;


  @Override
  public String getMeaning() {
    return meaning;
  }

  @Override
  public void setMeaning(String meaning) {
    this.meaning = meaning;
  }

  @Override
  public String getText() {
    return text;
  }

  @Override
  public void setText(String text) {
    this.text = text;
  }

  @Override
  public String getComment() {
    return comment;
  }

  @Override
  public void setComment(String comment) {
    this.comment = comment;
  }

  @Override
  public KotobaForm getKotobaForm() {
    return null;
  }

  @Override
  public void setKotobaForm(KotobaForm kotobaForm) {
    //To change body of implemented methods use File | Settings | File Templates.
  }

  public AdjectiveFormImpl getAdjectiveForm() {
    return adjectiveForm;
  }

  public void setAdjectiveForm(AdjectiveFormImpl adjectiveForm) {
    this.adjectiveForm = adjectiveForm;
  }

  public boolean isAdjective() {
    return adjectiveForm != null;
  }

  public Set<KanjiImpl> getKanjis() {
    return kanjis;
  }

  public void setKanjis(Set<KanjiImpl> kanjis) {
    this.kanjis = kanjis;
  }

  public String getKana() {
    return kana;
  }

  public void setKana(String kana) {
    this.kana = kana;
  }
}
