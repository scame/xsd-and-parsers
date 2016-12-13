package parsers;


import java.util.ArrayList;
import java.util.List;

public class BottlingModel {

    private List<ContainerModel> containers;

    public BottlingModel() {
        containers = new ArrayList<>();
    }

    public void setContainers(List<ContainerModel> containers) {
        this.containers = containers;
    }

    public List<ContainerModel> getContainers() {
        return containers;
    }

    public void add(ContainerModel containerModel) {
        containers.add(containerModel);
    }
}
