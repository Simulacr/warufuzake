package desu.nya.server.processors.nihongo.grammar;

import java.util.List;

/**
 * User: Simulacr
 * Time: 26.12.14
 */
public interface SentencesProcessor {
  List<String> getSentencesByLesson(int lesson);
}
