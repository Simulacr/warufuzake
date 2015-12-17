package desu.nya.shared.nihongo.test.adposition;

import org.primefaces.component.panel.Panel;
import org.primefaces.component.panelgrid.PanelGrid;
import org.primefaces.component.tabview.Tab;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.function.Predicate;

/**
 * Created by Ker on 07.12.2015.
 */
public class AdpositionParser {
  private static final String path = "/resources/nihongo/test/total/";
  private static AdpositionParser instance;
  private DocumentBuilder builder;

  private AdpositionParser() {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    try {
      builder = factory.newDocumentBuilder();
    } catch (ParserConfigurationException e) {
      e.printStackTrace();
    }
  }

  private List<Test> getLightList() {
    Properties prop = new Properties();
    List<Test> list = new ArrayList<>();
    ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
    try {
      prop.load(externalContext.getResourceAsStream("tests.property"));
      String[] lessonsProps = prop.getProperty("lesson.list").split(",");
      for(String lessonProp: lessonsProps) {
        if(lessonProp.contains("-")) {
          for(int i = Integer.valueOf(lessonProp.split("-")[0]), count = Integer.valueOf(lessonProp.split("-")[1]); i <= count;i++) {
            final int currentLesson = i;
            if(!list.stream().anyMatch(e -> e.getLesson() == currentLesson))
              list.add(new Test(i, i));
          }
        } else  {
          int lesson = Integer.valueOf(lessonProp);
          if(!list.stream().anyMatch(e -> e.getLesson().equals(lesson)))
            list.add(new Test(lesson, lesson, prop.getProperty("lesson." + lesson, "No_header_defined")));
          }
        }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return list;
  }

    public Test get(int lesson) {
      Test test = new Test(lesson, lesson);
      try {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Document document =
            builder.parse(externalContext.getResourceAsStream(path + lesson + ".xml"));
        NodeList blocks = document.getDocumentElement().getChildNodes();
        for(int i=0; i < blocks.getLength(); i++) {
          Node block = blocks.item(i);
          if(block instanceof Element) {//block-tab
            int width = Integer.parseInt(((Element) block).getAttribute("width"));
            Tab tab = new Tab();
            String tabTitle = ((Element) block).getAttribute("label");
            tab.setTitle(tabTitle);
            tab.setId("tab" + i);
            PanelGrid panel = new PanelGrid();
            panel.setColumns(2);
            panel.setColumnClasses("no-padding");
            panel.setStyleClass("kanjiPanel");
            TestAdposition testAdposition = new TestAdposition(width);
            NodeList childNodes = block.getChildNodes();
            for(int j = 0; j< childNodes.getLength(); j++) {
              Node child = childNodes.item(j);
              if(child instanceof Element) {
                String content = child.getTextContent().trim();
                String label = ((Element) child).getAttribute("label");
                testAdposition.addAdpositionUnit(content, child.getNodeName(), label, panel);
              }
            }
            tab.getChildren().add(panel);
            test.getTabs().add(tab);
            test.addTest(testAdposition);
          }
        }
      } catch (SAXException | IOException e) {
        e.printStackTrace();
      }
      return test;
    }

  public static AdpositionParser getInstance()
  {
    if(instance == null)
      instance = new AdpositionParser();
    return instance;
  }

  public List<Integer> getLessons() {
    return null;
  }
}
