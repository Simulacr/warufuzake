package desu.nya.web.forms.nihongo.tekisto;

import desu.nya.services.nihongo.tekisto.TekistoService;
import desu.nya.web.forms.GenericFormManipulator;
import desu.nya.web.forms.Manipulator;
import org.springframework.stereotype.Controller;

/**
 * User: fess
 * Date: 05.01.15
 */
@Controller
@Manipulator(value = "tekisto", editForm = TekistoUpdateForm.class, listForm = TekistoListForm.class, service = TekistoService.class)
public class TekistoFormManipulator extends GenericFormManipulator{
}
