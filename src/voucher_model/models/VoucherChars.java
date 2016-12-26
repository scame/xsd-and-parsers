package voucher_model.models;


public class VoucherChars {

    private int stars;

    private String food;

    private int room;

    private boolean isTv;

    private boolean isAirConditioning;

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public boolean isTv() {
        return isTv;
    }

    public void setTv(boolean tv) {
        isTv = tv;
    }

    public boolean isAirConditioning() {
        return isAirConditioning;
    }

    public void setAirConditioning(boolean airConditioning) {
        isAirConditioning = airConditioning;
    }

    @Override
    public String toString() {
        return stars + " " + food + " " + " " + room + " " + isTv + " " + isAirConditioning;
    }
}
