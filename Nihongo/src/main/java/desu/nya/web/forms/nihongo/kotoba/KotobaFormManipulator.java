package desu.nya.web.forms.nihongo.kotoba;

import desu.nya.server.entities.Kotoba;
import desu.nya.services.nihongo.kotoba.KotobaService;
import desu.nya.web.forms.GenericFormManipulator;
import desu.nya.web.forms.Manipulator;
import org.springframework.stereotype.Controller;

/**
 *
 * @author fess
 */
@Controller
@Manipulator(value = "kotoba", editForm = KotobaUpdateForm.class, listForm = KotobaListForm.class, service = KotobaService.class)
public class KotobaFormManipulator extends GenericFormManipulator<Kotoba, KotobaService>{
    
}
