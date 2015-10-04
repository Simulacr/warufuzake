package desu.nya.web.forms.nihongo.katakana;

import desu.nya.server.entities.Kanji;
import desu.nya.services.nihongo.kanji.KanjiService;
import desu.nya.shared.enums.FormType;
import desu.nya.web.forms.GenericFormManipulator;
import desu.nya.web.forms.Manipulator;
import org.springframework.stereotype.Controller;

/**
 *
 * @author fess
 */
@Controller
@Manipulator(value = "katakana", editForm = KatakanaUpdateForm.class, listForm = KatakanaListForm.class, service = KanjiService.class)
public class KatakanaFormManipulator extends GenericFormManipulator<Kanji, KanjiService>{

}
