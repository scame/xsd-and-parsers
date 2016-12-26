package voucher_model.parsers;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import voucher_model.VouchersComparator;
import voucher_model.models.VoucherChars;
import voucher_model.models.VoucherCosts;
import voucher_model.models.VoucherModel;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DomVoucherParser {

    private final List<VoucherModel> voucherModels = new ArrayList<>();

    private VoucherModel voucherModel;

    private void parse() {
        Element rootElement = getRoot();
        NodeList beerNodes = rootElement.getElementsByTagName("voucher");

        for (int i = 0; i < beerNodes.getLength(); i++) {
            voucherModel = new VoucherModel();
            voucherModels.add(voucherModel);

            Element voucherItem = (Element) beerNodes.item(i);
            parseRootAttrs(voucherItem);
            parseHotelChars(voucherItem);
            parseCost(voucherItem);
        }
    }


    private void parseCost(Element voucherItem) {
        Element costElement = getCostElement(voucherItem);
        VoucherCosts voucherCosts = new VoucherCosts();
        voucherCosts.setPrice(Integer.valueOf(costElement.getAttribute("price")));

        int girls = Integer.valueOf(costElement.getElementsByTagName("girls").item(0).getTextContent());
        int meal = Integer.valueOf(costElement.getElementsByTagName("meal").item(0).getTextContent());
        int drink = Integer.valueOf(costElement.getElementsByTagName("drink").item(0).getTextContent());

        voucherCosts.setDrink(drink);
        voucherCosts.setFood(meal);
        voucherCosts.setGirls(girls);
        voucherModel.setVoucherCosts(voucherCosts);
    }

    private Element getCostElement(Element voucherItem) {
        NodeList nodeList = voucherItem.getElementsByTagName("cost");
        return (Element) nodeList.item(0);
    }


    private void parseHotelChars(Element voucherItem) {
        Element hotelCharsElem = getHotelCharsElement(voucherItem);
        VoucherChars voucherChars = new VoucherChars();

        int stars = Integer.valueOf(hotelCharsElem.getElementsByTagName("stars").item(0).getTextContent());
        String food = hotelCharsElem.getElementsByTagName("food").item(0).getTextContent();
        int room = Integer.valueOf(hotelCharsElem.getElementsByTagName("room").item(0).getTextContent());
        boolean isTV = Boolean.valueOf(hotelCharsElem.getElementsByTagName("isTV").item(0).getTextContent());
        boolean isAirConditioning = Boolean.valueOf(hotelCharsElem.getElementsByTagName("isAirConditioning").item(0).getTextContent());

        voucherChars.setAirConditioning(isAirConditioning);
        voucherChars.setTv(isTV);
        voucherChars.setRoom(room);
        voucherChars.setFood(food);
        voucherChars.setStars(stars);

        voucherModel.setVoucherChars(voucherChars);
    }

    private Element getHotelCharsElement(Element rootElement) {
        NodeList nodeList = rootElement.getElementsByTagName("hotel_chars");
        return (Element) nodeList.item(0);
    }

    private void parseRootAttrs(Element voucherItem) {
        voucherModel.setType(voucherItem.getAttribute("type"));
        voucherModel.setNumberDayAndNights(voucherItem.getAttribute("number_day_nights"));
        voucherModel.setTransport(voucherItem.getAttribute("transport"));
        voucherModel.setCountry(voucherItem.getAttribute("country"));
    }

    private Element getRoot() {
        Document doc = getDocument();
        doc.getDocumentElement().normalize();
        return doc.getDocumentElement();
    }

    private Document getDocument() {
        File inputFile = new File("src/voucher_model/voucher.xml");
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

    private void print() {
        voucherModels.sort(new VouchersComparator());
        voucherModels.forEach(System.out::println);
    }

    public static void main(String[] args) {
        DomVoucherParser domVoucherParser = new DomVoucherParser();
        domVoucherParser.parse();
        domVoucherParser.print();
    }
}
