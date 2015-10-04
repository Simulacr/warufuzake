package desu.nya.server.entities.impl;

import desu.nya.server.entities.Tekisto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * User: fess
 * Date: 05.01.15
 */
@Entity
@Table(name = "TEKISTO", schema = "APP")
public class TekistoImpl extends GenericHasLessonEntityImpl implements Tekisto {
  @Column(name = "description")
  private String description;
  @Column(name = "document")
  private String documentPath;
  @Column(name = "audio")
  private String audioPath;

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getDocumentPath() {
    return documentPath;
  }

  public void setDocumentPath(String documentPath) {
    this.documentPath = documentPath;
  }

  public String getAudioPath() {
    return audioPath;
  }

  public void setAudioPath(String audioPath) {
    this.audioPath = audioPath;
  }

}
