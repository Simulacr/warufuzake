package desu.nya.web.validators;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Hashtable;
import java.util.Set;

/**
 * User: Simulacr
 * Time: 07.01.15
 */
public class TestHandler {
  private Hashtable<String, String> tags;

  public static final String TABLE_TAG = "table";
  public static final String ROW_TAG = "row";
  public static final String COL_TAG = "col";
  public static final String ANSWER_TAG = "answer";


  public static final String MARU_BATSU_PANEL_TAG = "maru-batsu-panel";
  public static final String REI_TAG = "rei";
  public static final String ROW_PANEL_TAG = "row";

  public void startDocument() throws SAXException {
    tags = new Hashtable<>();
  }

  public void endDocument() throws SAXException {
    for(String tag:tags.keySet()) {

  } }

  public void parse(String filename) {

  }
}
