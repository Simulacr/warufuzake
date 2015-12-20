package desu.nya.web.beans;

import desu.nya.shared.utils.Translator;
import desu.nya.shared.utils.UserUtils;

import java.io.Serializable;
import javax.annotation.PostConstruct;

import org.primefaces.event.ToggleEvent;
import org.primefaces.model.menu.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * @author fess
 */
@Controller("menuBean")
@Scope("session")
public class MenuBean implements Serializable {

  @Autowired
  private Translator translator;
  private MenuModel shortcutsMenu;
  private MenuModel megaMenu;

  public String getUserDisplayName() {
    return UserUtils.getCurrentPreferences().getDisplayName();
  }

  @PostConstruct
  public void initBean() {
    shortcutsMenu = new DefaultMenuModel();
    shortcutsMenu.addElement(createSubMenu("Learning",
            createMenuItem("Hiragana", "hiragana", true),
            createMenuItem("Katakana", "katakana", true),
            createMenuItem("Kanji", "kanji", true),
            createMenuItem("Kotoba", "kotoba", true),
            createMenuItem("Text", "tekisto", true)));
    shortcutsMenu.addElement(createSubMenu("Test",
//            createMenuItem("Hiragana", "hiragana", false),
//            createMenuItem("Katakana", "katakana", false),
//            createMenuItem("Kanji", "kanji", false),
            createMenuItem("Test", "testo", true),
            createMenuItem("Kotoba", "kotobaQuiz", true)));
    shortcutsMenu.addElement(createSubMenu("Books",
//            createMenuItem("Minna_no_nihongo", "minnaNoNihongo", false),
//            createMenuItem("Grammatical_test", "grammatical", false),
            createMenuItem("Audition", "audition", true)));

    megaMenu = new DefaultMenuModel();
    megaMenu.addElement(createMegaSubMenu("Investigate",
            createMenuItem("Kana", "kana", true),
            createMenuItem("Kanji", "kanji", true),
            createMenuItem("Kotoba", "kotoba", true),
            createMenuItem("Grammatic", "grammatic", true)));
    megaMenu.addElement(createMegaSubMenu("Books_Audio",
//            createMenuItem("Kaiwa", "kaiwa", false),
//            createMenuItem("Renshuu", "renshuu", false),
//            createMenuItem("Audition", "audition", false),
//            createMenuItem("Text", "tekisto", false),
            createMenuItem("Bunkei_Renbun", "bunkei", false)));
    megaMenu.addElement(createMegaSubMenu("Admin",
            createMenuItem("Users", "users", true),
            createMenuItem("User_groups", "userGroups", true)));
    megaMenu.addElement(createMenuItem("Preferences", "preferences", true));
    megaMenu.addElement(createLoqoutItem());

  }

  private DefaultMenuItem createMenuItem(String name, String page, boolean enabled) {
    DefaultMenuItem item = new DefaultMenuItem(translator.getString(name));
    item.setCommand("#{navigation.handleAction(\"" + page + "\")}");
    item.setUpdate(":contentForm");
    item.setDisabled(!enabled);
    return item;
  }

  private DefaultMenuItem createLoqoutItem() {
    DefaultMenuItem item = new DefaultMenuItem(translator.getString("Quit"));
    item.setUrl("/logout");
    item.setUpdate(":contentForm");
    return item;
  }

  private DefaultSubMenu createMegaSubMenu(String name, DefaultMenuItem... items) {
    DefaultSubMenu submenu = new DefaultSubMenu();
    submenu.setId("megaMenuSubMenu");
    for (DefaultMenuItem item : items)
      submenu.addElement(item);
    DefaultMenuColumn column = new DefaultMenuColumn();
    column.addElement(submenu);
    column.setId("megaMenuSubMenu");
    DefaultSubMenu secondSubmenu = new DefaultSubMenu(translator.getString(name));
    secondSubmenu.addElement(column);
    secondSubmenu.setId("megaMenuSubMenu1");
    return secondSubmenu;
  }


  private DefaultSubMenu createSubMenu(String name, DefaultMenuItem... items) {
    DefaultSubMenu submenu = new DefaultSubMenu(translator.getString(name));
    for (DefaultMenuItem item : items)
      submenu.addElement(item);
    return submenu;
  }

  public MenuModel getMenuModel() {
    return shortcutsMenu;
  }

  public MenuModel getMegaMenu() {
    return megaMenu;
  }
}
