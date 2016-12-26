package voucher_model.parsers;


import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class SaxVouchersParser {

    public static void main(String[] args) {
        try {
            File inputFile = new File("src/voucher_model/voucher.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            VoucherHandler voucherHandler = new VoucherHandler();
            saxParser.parse(inputFile, voucherHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
