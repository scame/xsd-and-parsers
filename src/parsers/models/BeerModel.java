package parsers.models;


import java.util.ArrayList;
import java.util.List;

public class BeerModel {

    private String name;

    private String type;

    private boolean isAlcoholic;

    private String manufacturer;

    private int id;

    private List<String> ingredients;

    private CharacteristicsModel characteristics;

    public BeerModel() {
        ingredients = new ArrayList<>();
        characteristics = new CharacteristicsModel();
    }

    public void addIngredient(String ingredient) {
        this.ingredients.add(ingredient);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAlcoholic(boolean alcoholic) {
        isAlcoholic = alcoholic;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public void setCharacteristics(CharacteristicsModel characteristics) {
        this.characteristics = characteristics;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public boolean isAlcoholic() {
        return isAlcoholic;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getId() {
        return id;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public CharacteristicsModel getCharacteristics() {
        return characteristics;
    }

    @Override
    public String toString() {
        return name + " " +
                type + " " +
                isAlcoholic + " " +
                manufacturer + " " +
                id + "\n" +
                ingredients + "\n"
                + characteristics;
    }
}
