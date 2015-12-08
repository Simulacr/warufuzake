package desu.nya.web.forms.nihongo.test;

import desu.nya.services.GenericService;
import desu.nya.web.forms.GenericFormManipulator;
import desu.nya.web.forms.Manipulator;
import org.springframework.stereotype.Controller;

/**
 * Created by Ker on 07.12.2015.
 */
@Controller
@Manipulator(value = "tekisto", editForm = TestUpdateForm.class, listForm = TestListForm.class, service = GenericService.class)
public class TestFormMediator extends GenericFormManipulator {
}
