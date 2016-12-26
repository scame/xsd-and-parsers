package voucher_model.models;


public class VoucherModel {

    private String type;

    private String country;

    private String numberDayAndNights;

    private String transport;

    private VoucherChars voucherChars;

    private VoucherCosts voucherCosts;

    public void setType(String type) {
        this.type = type;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setNumberDayAndNights(String numberDayAndNights) {
        this.numberDayAndNights = numberDayAndNights;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public void setVoucherChars(VoucherChars voucherChars) {
        this.voucherChars = voucherChars;
    }

    public void setVoucherCosts(VoucherCosts voucherCosts) {
        this.voucherCosts = voucherCosts;
    }

    public String getType() {
        return type;
    }

    public String getCountry() {
        return country;
    }

    public String getNumberDayAndNights() {
        return numberDayAndNights;
    }

    public String getTransport() {
        return transport;
    }

    public VoucherChars getVoucherChars() {
        return voucherChars;
    }

    public VoucherCosts getVoucherCosts() {
        return voucherCosts;
    }

    @Override
    public String toString() {
        return type + " " + country + " " + numberDayAndNights + " " + transport + " " +
                " " + voucherChars + " " + voucherCosts;
    }
}
