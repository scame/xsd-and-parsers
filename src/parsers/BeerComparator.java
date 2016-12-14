package parsers;


import parsers.models.BeerModel;

import java.util.Comparator;

public class BeerComparator implements Comparator<BeerModel> {

    @Override
    public int compare(BeerModel beerModel, BeerModel t1) {
        if (beerModel.getName().compareTo(t1.getName()) != 0) {
            return beerModel.getName().compareTo(t1.getName());
        } else if (beerModel.getType().compareTo(t1.getType()) != 0) {
            return beerModel.getType().compareTo(t1.getType());
        } else if (beerModel.getId() != t1.getId()) {
            return beerModel.getId() - t1.getId();
        } else if (beerModel.getManufacturer().compareTo(t1.getManufacturer()) != 0) {
            return beerModel.getManufacturer().compareTo(t1.getManufacturer());
        }
        return 0;
    }
}
