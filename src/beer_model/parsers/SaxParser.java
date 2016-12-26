package beer_model.parsers;


import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class SaxParser {

    public static void main(String[] args) {
        try {
            File inputFile = new File("src/beer.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            BeerHandler beerHandler = new BeerHandler();
            saxParser.parse(inputFile, beerHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
