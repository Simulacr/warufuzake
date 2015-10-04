package desu.nya.services.nihongo.grammar;

import desu.nya.services.GenericService;
import desu.nya.shared.nihongo.GrammarTestEntry;

/**
 * User: Simulacr
 * Time: 26.12.14
 */
public interface GrammarTestService extends GenericService<GrammarTestEntry>{

  GrammarTestEntry getGrammarTestByLesson(int lesson);
}
