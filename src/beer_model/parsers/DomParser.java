package beer_model.parsers;


import beer_model.BeerComparator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import beer_model.models.BeerModel;
import beer_model.models.CharacteristicsModel;
import beer_model.models.ContainerModel;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DomParser {

    private final List<BeerModel> beers = new ArrayList<>();

    private BeerModel beerModel;

    public void parse() {
        Element rootElement = getRoot();
        NodeList beerNodes = rootElement.getElementsByTagName("beer");

        for (int i = 0; i < beerNodes.getLength(); i++) {
            beerModel = new BeerModel();
            beers.add(beerModel);

            Element beerElement = (Element) beerNodes.item(i);
            parseRootAttrs(beerElement);
            parseIngredients(beerElement);
            parseCharacteristics(beerElement);
        }
    }

    private void parseCharacteristics(Element rootElement) {
        Element charsElement = getCharsElement(rootElement);
        parseCharsSubelements(charsElement);
    }

    private void parseCharsSubelements(Element charsElement) {
        CharacteristicsModel characteristics = new CharacteristicsModel();

        characteristics.setAlcPercentage(Double.valueOf(charsElement
                .getElementsByTagName("alcPercentage").item(0).getTextContent()));
        characteristics.setCalorificValue(charsElement.getElementsByTagName("caloroficValue").item(0).getTextContent());
        characteristics.setFiltered(Boolean.valueOf(charsElement.getElementsByTagName("isFiltered").item(0).getTextContent()));
        characteristics.setTransparency(charsElement.getElementsByTagName("transparency").item(0).getTextContent());

        parseBottling(charsElement, characteristics);
        beerModel.setCharacteristics(characteristics);
    }

    private void parseBottling(Element charsElement, CharacteristicsModel characteristics) {
        Element bottlingElem = (Element) charsElement.getElementsByTagName("bottling").item(0);
        NodeList containers =  bottlingElem.getElementsByTagName("container");

        for (int i = 0; i < containers.getLength(); i++) {
            ContainerModel container = new ContainerModel();

            Element containerElem = (Element) containers.item(i);
            container.setMaterial(containerElem.getElementsByTagName("material").item(0).getTextContent());
            container.setCapacity(Double.valueOf(containerElem.getElementsByTagName("capacity").item(0).getTextContent()));
            characteristics.addContainer(container);
        }
    }

    private Element getCharsElement(Element rootElement) {
        NodeList nodeList = rootElement.getElementsByTagName("characteristics");
        return (Element) nodeList.item(0);
    }

    private void parseIngredients(Element rootElement) {
        Element ingredientElem = getIngredientElement(rootElement);
        List<String> ingredients = new ArrayList<>();
        NodeList ingredientsList = ingredientElem.getElementsByTagName("ingredient");

        for (int i = 0; i < ingredientsList.getLength(); i++) {
            ingredients.add(ingredientsList.item(i).getTextContent());
        }
        beerModel.setIngredients(ingredients);
    }

    private Element getIngredientElement(Element rootElement) {
        NodeList nodeList = rootElement.getElementsByTagName("ingredients");
        return (Element) nodeList.item(0);
    }

    private void parseRootAttrs(Element rootElement) {
        beerModel.setAlcoholic(Boolean.valueOf(rootElement.getAttribute("isAlcoholic")));
        beerModel.setId(Integer.valueOf(rootElement.getAttribute("id")));
        beerModel.setName(rootElement.getAttribute("name"));
        beerModel.setType(rootElement.getAttribute("type"));
        beerModel.setManufacturer(rootElement.getAttribute("manufacturer"));
    }


    public static void main(String[] args) {
        DomParser domParser = new DomParser();
        domParser.parse();
        domParser.print();
    }

    private Element getRoot() {
        Document doc = getDocument();
        doc.getDocumentElement().normalize();
        return doc.getDocumentElement();
    }

    private Document getDocument() {
        File inputFile = new File("src/beer.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        Document doc = null;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(inputFile);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return doc;
    }

    public void print() {
        beers.sort(new BeerComparator());
        beers.forEach(System.out::println);
    }
}
