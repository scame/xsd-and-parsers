package parsers.models;


import java.util.ArrayList;
import java.util.List;

public class CharacteristicsModel {

    private boolean isFiltered;

    private double alcPercentage;

    private String calorificValue;

    private String transparency;

    private List<ContainerModel> containers;

    public CharacteristicsModel() {
        containers = new ArrayList<>();
    }

    public void setContainers(List<ContainerModel> containers) {
        this.containers = containers;
    }

    public void setFiltered(boolean filtered) {
        isFiltered = filtered;
    }

    public void setAlcPercentage(double alcPercentage) {
        this.alcPercentage = alcPercentage;
    }

    public void setCalorificValue(String calorificValue) {
        this.calorificValue = calorificValue;
    }

    public void setTransparency(String transparency) {
        this.transparency = transparency;
    }

    public boolean isFiltered() {
        return isFiltered;
    }

    public double getAlcPercentage() {
        return alcPercentage;
    }

    public String getCalorificValue() {
        return calorificValue;
    }

    public String getTransparency() {
        return transparency;
    }

    public List<ContainerModel> getContainers() {
        return containers;
    }

    public void addContainer(ContainerModel container) {
        containers.add(container);
    }

    @Override
    public String toString() {
        return isFiltered + " " +
                alcPercentage + " " +
                calorificValue + " " +
                transparency + "\n" +
                containers;
    }
}
