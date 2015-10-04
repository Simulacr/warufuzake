package desu.nya.services.nihongo.grammar;

import desu.nya.server.processors.nihongo.grammar.SentencesProcessor;
import desu.nya.shared.nihongo.GrammarTestEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: Simulacr
 * Time: 26.12.14
 */
@Service("grammarTestService")
public class GrammarTestServiceImpl implements GrammarTestService {
  @Autowired
  private SentencesProcessor processor;

  @Override
  public GrammarTestEntry createNewEntity() {
    return null;
  }

  @Override
  public void save(GrammarTestEntry entity) {

  }

  @Override
  public void removeList(List<GrammarTestEntry> list) {

  }

  @Override
  public void removeList(GrammarTestEntry[] list) {

  }

  @Override
  public List<GrammarTestEntry> getFullList() {
    return null;
  }

  @Override
  public GrammarTestEntry getGrammarTestByLesson(int lesson) {
    return new GrammarTestEntry(processor.getSentencesByLesson(lesson));
  }
}
