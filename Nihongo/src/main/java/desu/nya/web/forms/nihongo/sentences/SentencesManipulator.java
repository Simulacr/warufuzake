package desu.nya.web.forms.nihongo.sentences;

import desu.nya.services.nihongo.grammar.GrammarTestService;
import desu.nya.shared.nihongo.GrammarTestEntry;
import desu.nya.web.forms.GenericFormManipulator;
import desu.nya.web.forms.Manipulator;
import org.springframework.stereotype.Controller;

/**
 *
 * @author fess
 */
@Controller
@Manipulator(value = "sentences", editForm = SentencesUpdateForm.class, listForm = SentencesListForm.class, service = GrammarTestService.class)
public class SentencesManipulator  extends GenericFormManipulator{
    
}
