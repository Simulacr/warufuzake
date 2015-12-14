package desu.nya.shared.nihongo.test.adposition;

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
import java.util.List;

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


    public Test get(int lesson) {
      Test test = new Test(lesson, lesson);
      try {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Document document =
            builder.parse(externalContext.getResourceAsStream(path + lesson + ".xml"));
        NodeList blocks = document.getDocumentElement().getChildNodes();
        for(int i=0; i < blocks.getLength(); i++) {
          Node block = blocks.item(i);
          if(block instanceof Element) {//block
            TestAdposition testAdposition = new TestAdposition();
            NodeList childNodes = block.getChildNodes();
            for(int j = 0; j< childNodes.getLength(); j++) {
              Node child = childNodes.item(j);
              if(child instanceof Element) {
                String content = child.getTextContent().trim();
                testAdposition.addAdpositionUnit(test.getPanel(), content, child.getNodeName());
              }
            }
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
