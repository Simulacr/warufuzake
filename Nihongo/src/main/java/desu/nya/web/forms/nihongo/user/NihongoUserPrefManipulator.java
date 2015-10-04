package desu.nya.web.forms.nihongo.user;

import desu.nya.web.forms.Manipulator;
import desu.nya.web.forms.technical.UserPreferenceManipulator;
import org.springframework.stereotype.Controller;

/**
 * Created by ievstratov on 07.05.2015.
 */
@Controller
@Manipulator(value = "nihongoUserPreferences")
public class NihongoUserPrefManipulator extends UserPreferenceManipulator {
}
