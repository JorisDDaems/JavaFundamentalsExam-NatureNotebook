package be.intecbrussel.entities.plant_entities;

public class Tree extends Plant{

    private LeafType leafType;

    public Tree(String name) {
        super(name);
    }

    public Tree(String name, LeafType leafType) {
        super(name);
        this.leafType = leafType;
    }

    public LeafType getLeafType() {
        return leafType;
    }

    public void setLeafType(LeafType leafType) {
        this.leafType = leafType;
    }

    @Override
    public String toString() {
        return "Tree{"+ super.toString() +
                "leafType=" + leafType +
                "} ";
    }
}
