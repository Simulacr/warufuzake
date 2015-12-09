package desu.nya.web.forms.nihongo.test;

import desu.nya.services.GenericService;
import desu.nya.services.nihongo.test.TestService;
import desu.nya.web.forms.GenericFormManipulator;
import desu.nya.web.forms.Manipulator;
import org.springframework.stereotype.Controller;

/**
 * Created by Ker on 07.12.2015.
 */
@Controller
@Manipulator(value = "testo", editForm = TestUpdateForm.class, listForm = TestListForm.class, service = TestService.class)
public class TestFormMediator extends GenericFormManipulator {
}
