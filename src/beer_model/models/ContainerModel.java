package beer_model.models;


public class ContainerModel {

    private String material;

    private double capacity;

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public String getMaterial() {
        return material;
    }

    public double getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return material + " " + capacity;
    }
}
