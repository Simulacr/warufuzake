package desu.nya.server.entities;

/**
 *
 * @author fess
 */
public interface Kotoba extends HasLessonEntity{

  String getMeaning();

  void setMeaning(String meaning);

  String getText();

  void setText(String text);

  String getComment();

  void setComment(String comment);

  KotobaForm getKotobaForm();

  void setKotobaForm(KotobaForm kotobaForm);

  boolean isAdjective();

  boolean isVerb();
}
