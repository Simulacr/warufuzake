package desu.nya.web.validators;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 * User: Simulacr
 * Time: 07.01.15
 */
public class TestErrorHandler implements ErrorHandler {
  @Override
  public void warning(SAXParseException exception) throws SAXException {

  }

  @Override
  public void error(SAXParseException exception) throws SAXException {

  }

  @Override
  public void fatalError(SAXParseException exception) throws SAXException {

  }
}
