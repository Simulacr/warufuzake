package desu.nya.server.entities.impl;

import desu.nya.server.entities.Sentences;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * User: Simulacr
 * Time: 26.12.14
 */
@Entity
@Table(name = "SENTENCES", schema = "APP")
public class SentencesImpl extends GenericHasLessonEntityImpl implements Sentences {
  @Column(name = "sentences")
  private String sentences;

  @Override
  public String getSentences() {
    return sentences;
  }

  @Override
  public void setSentences(String sentences) {
    this.sentences = sentences;
  }
}
