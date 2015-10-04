package desu.nya.server.entities.impl;

import desu.nya.server.entities.Kanji;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * @author fess
 */
@Entity
@Table(name = "KANJI", schema = "APP")
public class KanjiImpl extends GenericHasLessonEntityImpl implements Kanji {
  @Column(name = "kanji")
  @Size(min = 1, max = 1)
  private String kanji;
  @Column(name = "onyomi")
  @Pattern(regexp = "[あ-ん]\\d")
  private String onyomi;
  @Column(name = "kunyomi")
  @Pattern(regexp = "[ア-ン]\\d")
  private String kunyomi;
  @Column(name = "meaning")
  private String meaning;
  @Column(name="number", unique = true)
  @Min(1)
  private Integer number;
  @ManyToMany(fetch = FetchType.LAZY, mappedBy = "kanjis")
  private Set<KotobaImpl> kotobas;

  @Override
  public String getKanji() {
    return kanji;
  }

  @Override
  public void setKanji(String kanji) {
    this.kanji = kanji;
  }

  @Override
  public String getMeaning() {
    return meaning;
  }

  @Override
  public void setMeaning(String meaning) {
    this.meaning = meaning;
  }

  public String getOnyomi() {
    return onyomi;
  }

  public void setOnyomi(String onyomi) {
    this.onyomi = onyomi;
  }

  public String getKunyomi() {
    return kunyomi;
  }

  public void setKunyomi(String kunyomi) {
    this.kunyomi = kunyomi;
  }

  public Integer getNumber() {
    return number;
  }

  public void setNumber(Integer number) {
    this.number = number;
  }

  public Set<KotobaImpl> getKotobas() {
    return kotobas;
  }

  public void setKotobas(Set<KotobaImpl> kotobas) {
    this.kotobas = kotobas;
  }
}
