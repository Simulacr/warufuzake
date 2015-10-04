package desu.nya.web.validators;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

/**
 * User: Simulacr
 * Time: 07.01.15
 */
public class Test {
  private XMLReader xmlReader;

  public void read(String filename) throws ParserConfigurationException, SAXException, IOException {
    SAXParserFactory spf = SAXParserFactory.newInstance();
    SAXParser saxParser = spf.newSAXParser();
    XMLReader reader = saxParser.getXMLReader();
    reader.setErrorHandler(new TestErrorHandler());
    reader.parse("file:" + new File(filename).getAbsolutePath());
  }
}
