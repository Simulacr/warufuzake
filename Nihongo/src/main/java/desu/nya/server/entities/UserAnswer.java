package desu.nya.server.entities;

/**
 * User: Simulacr
 * Time: 29.12.14
 */
public interface UserAnswer extends GenericBindEntity{
  void setSentences(Sentences sentences);
  Sentences getSentences();

  void setAnswer(String answer);
  String getAnswer();
}
