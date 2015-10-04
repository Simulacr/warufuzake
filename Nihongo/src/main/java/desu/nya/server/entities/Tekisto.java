package desu.nya.server.entities;

/**
 * User: fess
 * Date: 05.01.15
 */
public interface Tekisto extends HasLessonEntity {
  void setDescription(String description);
  String getDescription();

  void setAudioPath(String audioPath);
  String getAudioPath();

  void setDocumentPath(String documentPath);
  String getDocumentPath();
}
