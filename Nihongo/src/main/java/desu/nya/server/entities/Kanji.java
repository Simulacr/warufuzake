package desu.nya.server.entities;

/**
 *
 * @author fess
 */
public interface Kanji extends HasLessonEntity{

  String getKanji();

  void setKanji(String kanji);

  String getMeaning();

  void setMeaning(String meaning);

  String getOnyomi();

  void setOnyomi(String onyomi);

  String getKunyomi();

  void setKunyomi(String kunyomi);

  Integer getNumber();

  void setNumber(Integer number);
}
