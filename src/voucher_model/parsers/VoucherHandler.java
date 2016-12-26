package voucher_model.parsers;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import voucher_model.VouchersComparator;
import voucher_model.models.VoucherChars;
import voucher_model.models.VoucherCosts;
import voucher_model.models.VoucherModel;

import java.util.ArrayList;
import java.util.List;

public class VoucherHandler extends DefaultHandler {

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

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);

        if (qName.equals("voucher")) {
            voucherModel = new VoucherModel();
            voucherModels.add(voucherModel);

            voucherModel.setType(attributes.getValue("type"));
            voucherModel.setCountry(attributes.getValue("country"));
            voucherModel.setNumberDayAndNights(attributes.getValue("number_day_nights"));
            voucherModel.setTransport(attributes.getValue("transport"));

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
            voucherCosts.setPrice(Integer.valueOf(attributes.getValue("price")));
            voucherModel.setVoucherCosts(voucherCosts);
        }
    }


    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);

        if (bStars) {
            VoucherChars voucherChars = new VoucherChars();
            voucherChars.setStars(Integer.valueOf(new String(ch, start, length)));
            voucherModel.setVoucherChars(voucherChars);
            bStars = false;
        } else if (bFood) {
            VoucherChars voucherChars = voucherModel.getVoucherChars();
            voucherChars.setFood(new String(ch, start, length));
            bFood = false;
        } else if (bRoom) {
            VoucherChars voucherChars = voucherModel.getVoucherChars();
            voucherChars.setRoom(Integer.valueOf(new String(ch, start, length)));
            bRoom = false;
        } else if (bIsTv) {
            VoucherChars voucherChars = voucherModel.getVoucherChars();
            voucherChars.setTv(Boolean.valueOf(new String(ch, start, length)));
            bIsTv = false;
        } else if (bAirConditioning) {
            VoucherChars voucherChars = voucherModel.getVoucherChars();
            voucherChars.setAirConditioning(Boolean.valueOf(new String(ch, start, length)));
            bAirConditioning = false;
        } else if (bGirls) {
            VoucherCosts voucherCosts = voucherModel.getVoucherCosts();
            voucherCosts.setGirls(Integer.valueOf(new String(ch, start, length)));
            bGirls = false;
        } else if (bMeal) {
            VoucherCosts voucherCosts = voucherModel.getVoucherCosts();
            voucherCosts.setFood(Integer.valueOf(new String(ch, start, length)));
            bMeal = false;
        } else if (bDrink) {
            VoucherCosts voucherCosts = voucherModel.getVoucherCosts();
            voucherCosts.setDrink(Integer.valueOf(new String(ch, start, length)));
            bDrink = false;
        }
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        voucherModels.sort(new VouchersComparator());
        voucherModels.forEach(System.out::println);
    }
}
