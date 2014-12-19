package uk.ac.gcu.scottnoonmuc;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;


 //Fills list of RSS Items while the parser runs

public class RssParseHandler extends DefaultHandler {

    // List of items parsed
    private List<RssItem> rssItems;

    private RssItem currentItem;
//two booleans used to indicate what is being parsed

    // Parsing title indicator
    private boolean parsingTitle;
    // Parsing link indicator
    private boolean parsingLink;

    public RssParseHandler() {
        rssItems = new ArrayList();
    }
    //called when parsing is complete - returns list of RSS items
        public List<RssItem> getItems() {
        return rssItems;
    }
    // creates an empty RssItem object when an item start tag parsed
    // title/link tag parsed, indicators set true.
    @Override
    public void startElement(String uri, String localName, String vsName, Attributes attributes) throws SAXException {
        if ("item".equals(vsName)) {
            currentItem = new RssItem();
        } else if ("title".equals(vsName)) {
            parsingTitle = true;
        } else if ("link".equals(vsName)) {
            parsingLink = true;
        }
    }
    // adds current RssItem to list when closing tag is processed
    // sets indicators to false when title/link close tags are parsed
    @Override
    public void endElement(String uri, String localName, String vsName) throws SAXException {
        if ("item".equals(vsName)) {
            rssItems.add(currentItem);
            currentItem = null;
        } else if ("title".equals(vsName)) {
            parsingTitle = false;
        } else if ("link".equals(vsName)) {
            parsingLink = false;
        }
    }
    // fills RssItem object with data when tags parsed
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (parsingTitle) {
            if (currentItem != null)
                currentItem.setTitle(new String(ch, start, length));
        } else if (parsingLink) {
            if (currentItem != null) {
                currentItem.setLink(new String(ch, start, length));
                parsingLink = false;
            }
        }
    }
}
