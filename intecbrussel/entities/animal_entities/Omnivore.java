package be.intecbrussel.entities.animal_entities;

import be.intecbrussel.entities.plant_entities.Plant;

import javax.crypto.spec.PSource;
import java.util.*;

public class Omnivore extends Animal {

    private Set<Plant> plantDiet = new HashSet<>();
    private double maxFoodSize;


    public Omnivore(String name) {
        super(name);
    }

    public Omnivore(String name, double weight, double height, double length) {
        super(name, weight, height, length);
    }

    public Set<Plant> getPlantDiet() {
        return plantDiet;
    }

    public void setPlantDiet(Set<Plant> plantDiet) {
        this.plantDiet = plantDiet;
    }

    public double getMaxFoodSize() {
        return maxFoodSize;
    }

    public void setMaxFoodSize(double maxFoodSize) {
        this.maxFoodSize = maxFoodSize;
    }

    public void addPlantToDiet(Plant plant){
        if (!plantDiet.equals(plant)){
            plantDiet.add(plant);
        }
    }

    public void printDiet(){
        plantDiet.stream().forEach(System.out::println);
        System.out.println("Maximum food size: "+ getMaxFoodSize());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Omnivore omnivore = (Omnivore) o;
        return Double.compare(omnivore.maxFoodSize, maxFoodSize) == 0 &&
                Objects.equals(plantDiet, omnivore.plantDiet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plantDiet, maxFoodSize);
    }

    @Override
    public String toString() {
        return "Omnivore{" + super.toString() +
                "plantDiet=" + plantDiet +
                ", maxFoodSize=" + maxFoodSize +
                "} " ;
    }
}
