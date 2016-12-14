package parsers;


import parsers.models.BeerModel;
import parsers.models.ContainerModel;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class StaxParser {

    private final List<BeerModel> beers = new ArrayList<>();

    private BeerModel beerModel;

    private boolean bIngredient;

    private boolean bIsFiltered;

    private boolean bAlcPercentage;

    private boolean bCalorificValue;

    private boolean bTransparency;

    private boolean bMaterial;

    private boolean bCapacity;

    private void parse() throws XMLStreamException {
        XMLEventReader eventReader = getEventReader();

        while (eventReader.hasNext()) {
            XMLEvent event = eventReader.nextEvent();
            handleEvent(event);
        }
    }

    private void handleEvent(XMLEvent event) {
        switch (event.getEventType()) {
            case XMLStreamConstants.START_ELEMENT:
                handleStartElementEvent(event);
                break;
            case XMLStreamConstants.CHARACTERS:
                handleCharactersEvent(event);
                break;
            case XMLStreamConstants.END_DOCUMENT:
                beers.sort(new BeerComparator());
                beers.forEach(System.out::println);
        }
    }

    private void handleCharactersEvent(XMLEvent event) {
        Characters characters = event.asCharacters();

        if (bIngredient) {
            beerModel.getIngredients().add(characters.getData());
            bIngredient = false;
        } else if (bIsFiltered) {
            beerModel.getCharacteristics().setFiltered(Boolean.valueOf(characters.getData()));
            bIsFiltered = false;
        } else if (bAlcPercentage) {
            beerModel.getCharacteristics().setAlcPercentage(Double.valueOf(characters.getData()));
            bAlcPercentage = false;
        } else if (bCalorificValue) {
            beerModel.getCharacteristics().setCalorificValue(characters.getData());
            bCalorificValue = false;
        } else if (bTransparency) {
            beerModel.getCharacteristics().setTransparency(characters.getData());
            bTransparency = false;
        } else if (bMaterial) {
            ContainerModel containerModel = new ContainerModel();
            containerModel.setMaterial(characters.getData());
            beerModel.getCharacteristics().getContainers().add(containerModel);
            bMaterial = false;
        } else if (bCapacity) {
            List<ContainerModel> containers = beerModel.getCharacteristics().getContainers();
            ContainerModel container = containers.get(containers.size() - 1);
            container.setCapacity(Double.valueOf(characters.getData()));
            bCapacity = false;
        }
    }

    private void handleStartElementEvent(XMLEvent event) {
        StartElement startElement = event.asStartElement();
        String qName = startElement.getName().getLocalPart();

        if (qName.equalsIgnoreCase("beer")) {
            beerModel = new BeerModel();
            beers.add(beerModel);
            parseBeerAttrs(startElement);
        } else if (qName.equalsIgnoreCase("ingredient")) {
            bIngredient = true;
        } else if (qName.equalsIgnoreCase("isFiltered")) {
            bIsFiltered = true;
        } else if (qName.equalsIgnoreCase("alcPercentage")) {
            bAlcPercentage = true;
        } else if (qName.equalsIgnoreCase("caloroficValue")) {
            bCalorificValue = true;
        } else if (qName.equalsIgnoreCase("transparency")) {
            bTransparency = true;
        } else if (qName.equalsIgnoreCase("material")) {
            bMaterial = true;
        } else if (qName.equalsIgnoreCase("capacity")) {
            bCapacity = true;
        }
    }


    private void parseBeerAttrs(StartElement startElement) {
        Attribute attribute = startElement.getAttributeByName(new QName("name"));
        beerModel.setName(attribute.getValue());
        attribute = startElement.getAttributeByName(new QName("type"));
        beerModel.setType(attribute.getValue());
        attribute = startElement.getAttributeByName(new QName("isAlcoholic"));
        beerModel.setAlcoholic(Boolean.valueOf(attribute.getValue()));
        attribute = startElement.getAttributeByName(new QName("manufacturer"));
        beerModel.setManufacturer(attribute.getValue());
        attribute = startElement.getAttributeByName(new QName("id"));
        beerModel.setId(Integer.valueOf(attribute.getValue()));
    }

    private XMLEventReader getEventReader() {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLEventReader eventReader = null;
        try {
            eventReader = factory.createXMLEventReader(new FileReader("src/beer.xml"));
        } catch (XMLStreamException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return eventReader;
    }

    public static void main(String[] args) throws XMLStreamException {
        new StaxParser().parse();
    }
}
