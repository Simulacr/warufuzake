package desu.nya.web.forms.nihongo.test;

import desu.nya.shared.nihongo.test.adposition.TestAdposition;
import desu.nya.web.forms.GenericListForm;
import desu.nya.web.forms.GenericModel;

/**
 * Created by Ker on 07.12.2015.
 */
public class TestListForm extends GenericListForm<TestAdposition> {
    public void initModel() {
        super.initModel();
        model.addColumn("Number", ".id", 40, GenericModel.Align.center);
        model.addColumn("Number", ".lesson", 40, GenericModel.Align.center);
    }
}
