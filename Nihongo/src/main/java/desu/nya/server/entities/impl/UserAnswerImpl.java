package desu.nya.server.entities.impl;

import desu.nya.server.entities.Sentences;
import desu.nya.server.entities.UserAnswer;

import javax.persistence.*;

/**
 * User: Simulacr
 * Time: 01.01.15
 */
@Entity
@Table(name="USER_ANSWER", schema="APP")
public class UserAnswerImpl extends GenericBindEntityImpl implements UserAnswer {
  @ManyToOne(fetch= FetchType.EAGER)
  @JoinColumn(name="sentences_id")
  private SentencesImpl sentences;
  @Column(name = "answer")
  private String answer;

  @Override
  public SentencesImpl getSentences() {
    return sentences;
  }

  public void setSentences(Sentences sentences) {
    this.sentences = (SentencesImpl)sentences;
  }

  @Override
  public String getAnswer() {
    return answer;
  }

  @Override
  public void setAnswer(String answer) {
    this.answer = answer;
  }
}
