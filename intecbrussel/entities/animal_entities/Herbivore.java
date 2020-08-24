package be.intecbrussel.entities.animal_entities;

import be.intecbrussel.entities.plant_entities.Plant;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Herbivore extends Animal {

    private Set<Plant> plantDiet = new HashSet<>();

    public Set<Plant> getPlantDiet() {
        return plantDiet;
    }

    public void setPlantDiet(Set<Plant> plantDiet) {
        this.plantDiet = plantDiet;
    }

    public Herbivore(String name) {
        super(name);
    }

    public Herbivore(String name, double weight, double height, double length) {
        super(name, weight, height, length);
    }

    public void addPlantToDiet(Plant plant){
        if (!plantDiet.equals(plant)){
            plantDiet.add(plant);
        }
    }

    public void printDiet(){
        plantDiet.stream().forEach(System.out::println);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Herbivore herbivore = (Herbivore) o;
        return Objects.equals(plantDiet, herbivore.plantDiet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plantDiet);
    }

    @Override
    public String toString() {
        return "Herbivore{" + super.toString() +
                "plantDiet=" + plantDiet +
                "} " ;
    }
}
