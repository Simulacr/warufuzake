package desu.nya.web.forms.nihongo;

import desu.nya.server.entities.HasLessonEntity;
import desu.nya.services.nihongo.GenericLessonService;
import desu.nya.web.forms.GenericListForm;
import desu.nya.web.forms.ListMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ker on 26/10/2015.
 */
public class GenericHasLessonListForm<E extends HasLessonEntity> extends GenericListForm<E> {
    @Override
    protected void initMenu() {
        super.initMenu();
        List<Long> list = new ArrayList<>();
        Integer lastLesson  = ((GenericLessonService)getManipulator().getService()).getLastLessonNumber();
        for(Long i = 1l; i <= lastLesson; i++)
            list.add(i);
        menu.setSelector(new ListMenu.Selector<>(list, "Lesson"));
        menu.<Long>setClickCommand(target -> {
            ((GenericLessonService)getManipulator().getService()).getListOfLesson(target.intValue());
        });
    }
}
