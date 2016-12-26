package voucher_model.parsers;


import voucher_model.VouchersComparator;
import voucher_model.models.VoucherChars;
import voucher_model.models.VoucherCosts;
import voucher_model.models.VoucherModel;

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

public class StaxVoucherParser {

    private final List<VoucherModel> voucherModels = new ArrayList<>();

    private VoucherModel voucherModel;

    private boolean bStars;

    private boolean bFood;

    private boolean bRoom;

    private boolean bIsTv;

    private boolean bAirConditioning;

    private boolean bGirls;

    private boolean bMeal;

    private boolean bDrink;

    private void parse() throws XMLStreamException {
        XMLEventReader eventReader = getEventReader();

        while (eventReader.hasNext()) {
            XMLEvent event = eventReader.nextEvent();
            handleEvent(event);
        }
    }

    private XMLEventReader getEventReader() {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLEventReader eventReader = null;
        try {
            eventReader = factory.createXMLEventReader(new FileReader("src/voucher_model/voucher.xml"));
        } catch (XMLStreamException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return eventReader;
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
                voucherModels.sort(new VouchersComparator());
                voucherModels.forEach(System.out::println);
        }
    }

    private void handleCharactersEvent(XMLEvent event) {
        Characters characters = event.asCharacters();

        if (bStars) {
            VoucherChars voucherChars = new VoucherChars();
            voucherChars.setStars(Integer.valueOf(characters.getData()));
            voucherModel.setVoucherChars(voucherChars);
            bStars = false;
        } else if (bFood) {
            VoucherChars voucherChars = voucherModel.getVoucherChars();
            voucherChars.setFood(characters.getData());
            bFood = false;
        } else if (bRoom) {
            VoucherChars voucherChars = voucherModel.getVoucherChars();
            voucherChars.setRoom(Integer.valueOf(characters.getData()));
            bRoom = false;
        } else if (bIsTv) {
            VoucherChars voucherChars = voucherModel.getVoucherChars();
            voucherChars.setTv(Boolean.valueOf(characters.getData()));
            bIsTv = false;
        } else if (bAirConditioning) {
            VoucherChars voucherChars = voucherModel.getVoucherChars();
            voucherChars.setAirConditioning(Boolean.valueOf(characters.getData()));
            bAirConditioning = false;
        } else if (bGirls) {
            VoucherCosts voucherCosts = voucherModel.getVoucherCosts();
            voucherCosts.setGirls(Integer.valueOf(characters.getData()));
            bGirls = false;
        } else if (bMeal) {
            VoucherCosts voucherCosts = voucherModel.getVoucherCosts();
            voucherCosts.setFood(Integer.valueOf(characters.getData()));
            bMeal = false;
        } else if (bDrink) {
            VoucherCosts voucherCosts = voucherModel.getVoucherCosts();
            voucherCosts.setDrink(Integer.valueOf(characters.getData()));
            bDrink = false;
        }
    }

    private void handleStartElementEvent(XMLEvent event) {
        StartElement startElement = event.asStartElement();
        String qName = startElement.getName().getLocalPart();

        if (qName.equals("voucher")) {
            voucherModel = new VoucherModel();
            voucherModels.add(voucherModel);
            parseVoucherAttrs(startElement);

        } else if (qName.equals("stars")) {
            bStars = true;
        } else if (qName.equals("food")) {
            bFood = true;
        } else if (qName.equals("room")) {
            bRoom = true;
        } else if (qName.equals("isTV")) {
            bIsTv = true;
        } else if (qName.equals("isAirConditioning")) {
            bAirConditioning = true;
        } else if (qName.equals("girls")) {
            bGirls = true;
        } else if (qName.equals("meal")) {
            bMeal = true;
        } else if (qName.equals("drink")) {
            bDrink = true;
        } else if (qName.equals("cost")) {
            VoucherCosts voucherCosts = new VoucherCosts();
            voucherCosts.setPrice(Integer.valueOf(startElement.getAttributeByName(new QName("price")).getValue()));
            voucherModel.setVoucherCosts(voucherCosts);
        }
    }

    private void parseVoucherAttrs(StartElement startElement) {
        Attribute attribute = startElement.getAttributeByName(new QName("type"));
        voucherModel.setType(attribute.getValue());
        attribute = startElement.getAttributeByName(new QName("country"));
        voucherModel.setCountry(attribute.getValue());
        attribute = startElement.getAttributeByName(new QName("number_day_nights"));
        voucherModel.setNumberDayAndNights(attribute.getValue());
        attribute = startElement.getAttributeByName(new QName("transport"));
        voucherModel.setTransport(attribute.getValue());
    }

    public static void main(String[] args) throws XMLStreamException {
        new StaxVoucherParser().parse();
    }
}
