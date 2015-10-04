package desu.nya.shared.nihongo;

import desu.nya.server.entities.Sentences;

import java.util.List;

/**
 * User: Simulacr
 * Time: 29.12.14
 */
public class GrammarTestEntry {
  private List<String> sentenceses;
  private List<String> answers;

  public GrammarTestEntry(List<String> sentenceses) {
    this.sentenceses = sentenceses;
  }


  public List<String> getSentenceses() {
    return sentenceses;
  }

  public void setSentenceses(List<String> sentenceses) {
    this.sentenceses = sentenceses;
  }


}
