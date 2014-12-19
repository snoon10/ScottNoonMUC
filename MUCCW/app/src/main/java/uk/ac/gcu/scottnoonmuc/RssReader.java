package uk.ac.gcu.scottnoonmuc;

import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;




public class RssReader {

    private String rssUrl;
    //sets RSS URL
    public RssReader(String rssUrl) {
        this.rssUrl = rssUrl;
    }
    //gets parsed RSSItems
    public List<RssItem> getItems() throws Exception {

        //gets new SAXfactory object
        SAXParserFactory factory = SAXParserFactory.newInstance();

        //creates new instance
        SAXParser saxParser = factory.newSAXParser();

        //gets new handler object
        RssParseHandler handler = new RssParseHandler();

        //calls method to parse feed
        saxParser.parse(rssUrl, handler);

        //returns items from parser
        return handler.getItems();
    }
}
