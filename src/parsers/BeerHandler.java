package parsers;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import parsers.models.BeerModel;
import parsers.models.ContainerModel;

import java.util.ArrayList;
import java.util.List;

public class BeerHandler extends DefaultHandler {

    private final List<BeerModel> beers = new ArrayList<>();

    private BeerModel beerModel;

    private boolean bIngredient;

    private boolean bIsFiltered;

    private boolean bAlcPercentage;

    private boolean bCalorificVal;

    private boolean bTransparency;

    private boolean bMaterial;

    private boolean bCapacity;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);

        if (qName.equals("beer")) {
            beerModel = new BeerModel();
            beers.add(beerModel);

            beerModel.setManufacturer(attributes.getValue("manufacturer"));
            beerModel.setAlcoholic(Boolean.valueOf(attributes.getValue("isAlcoholic")));
            beerModel.setType(attributes.getValue("type"));
            beerModel.setName(attributes.getValue("name"));
            beerModel.setId(Integer.valueOf(attributes.getValue("id")));
        } else if (qName.equals("ingredient")) {
            bIngredient = true;
        } else if (qName.equals("isFiltered")) {
            bIsFiltered = true;
        } else if (qName.equals("alcPercentage")) {
            bAlcPercentage = true;
        } else if (qName.equals("caloroficValue")) {
            bCalorificVal = true;
        } else if (qName.equals("transparency")) {
            bTransparency = true;
        } else if (qName.equals("material")) {
            bMaterial = true;
        } else if (qName.equals("capacity")) {
            bCapacity = true;
        }
    }


    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);

        if (bIngredient) {
            beerModel.getIngredients().add(new String(ch, start, length));
            bIngredient = false;
        } else if (bIsFiltered) {
            beerModel.getCharacteristics().setFiltered(Boolean.valueOf(new String(ch, start, length)));
            bIsFiltered = false;
        } else if (bAlcPercentage) {
            beerModel.getCharacteristics().setAlcPercentage(Double.valueOf(new String(ch, start, length)));
            bAlcPercentage = false;
        } else if (bCalorificVal) {
            beerModel.getCharacteristics().setCalorificValue(new String(ch, start, length));
            bCalorificVal = false;
        } else if (bTransparency) {
            beerModel.getCharacteristics().setTransparency(new String(ch, start, length));
            bTransparency = false;
        } else if (bMaterial) {
            ContainerModel containerModel = new ContainerModel();
            containerModel.setMaterial(new String(ch, start, length));
            beerModel.getCharacteristics().getContainers().add(containerModel);
            bMaterial = false;
        } else if (bCapacity) {
            List<ContainerModel> containers = beerModel.getCharacteristics().getContainers();
            ContainerModel container = containers.get(containers.size() - 1);
            container.setCapacity(Double.valueOf(new String(ch, start, length)));
            bCapacity = false;
        }
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        beers.sort(new BeerComparator());
        beers.forEach(System.out::println);
    }
}
