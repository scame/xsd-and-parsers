package voucher_model;


import voucher_model.models.VoucherModel;

import java.util.Comparator;

public class VouchersComparator implements Comparator<VoucherModel> {


    @Override
    public int compare(VoucherModel voucherModel, VoucherModel t1) {
        if (voucherModel.getType().compareTo(t1.getType()) != 0) {
            return voucherModel.getType().compareTo(t1.getType());
        } else if (voucherModel.getCountry().compareTo(t1.getCountry()) != 0) {
            return voucherModel.getCountry().compareTo(t1.getCountry());
        } else if (voucherModel.getTransport().compareTo(t1.getTransport()) != 0) {
            return voucherModel.getTransport().compareTo(t1.getTransport());
        }
        return 0;
    }
}
