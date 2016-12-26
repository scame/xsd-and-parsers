package voucher_model.models;


public class VoucherCosts {

    private int price;

    private int girls;

    private int food;

    private int drink;

    public void setPrice(int price) {
        this.price = price;
    }

    public void setGirls(int girls) {
        this.girls = girls;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public void setDrink(int drink) {
        this.drink = drink;
    }

    public int getPrice() {
        return price;
    }

    public int getGirls() {
        return girls;
    }

    public int getFood() {
        return food;
    }

    public int getDrink() {
        return drink;
    }
}
