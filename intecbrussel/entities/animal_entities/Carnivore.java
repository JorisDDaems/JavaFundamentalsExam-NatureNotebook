package be.intecbrussel.entities.animal_entities;

import java.util.Objects;

public class Carnivore extends Animal{

    private double maxFoodSize;

    public Carnivore(String name) {
        super(name);
    }

    public Carnivore(String name, double weight, double height, double length) {
        super(name, weight, height, length);
    }

    public double getMaxFoodSize() {
        return maxFoodSize;
    }

    public void setMaxFoodSize(double maxFoodSize) {
        this.maxFoodSize = maxFoodSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carnivore carnivore = (Carnivore) o;
        return Double.compare(carnivore.maxFoodSize, maxFoodSize) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxFoodSize);
    }

    @Override
    public String toString() {
        return  "Carnivore{" +super.toString() +
                "{maxFoodSize=" + maxFoodSize +
                "} ";
    }
}
