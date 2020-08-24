package be.intecbrussel.service;

import be.intecbrussel.entities.animal_entities.Animal;
import be.intecbrussel.entities.animal_entities.Carnivore;
import be.intecbrussel.entities.animal_entities.Herbivore;
import be.intecbrussel.entities.animal_entities.Omnivore;
import be.intecbrussel.entities.plant_entities.Plant;

import java.util.*;
import java.util.stream.Collectors;

public class ForestNoteBook {

    private List<Carnivore> carnivores = new ArrayList<>();
    private List<Omnivore> omnivores = new ArrayList<>();
    private List<Herbivore> herbivores = new ArrayList<>();

    private int plantCount;
    private int animalCount;

    private List<Animal> animals = new ArrayList<>();
    private List<Plant> plants = new ArrayList<>();

    public List<Carnivore> getCarnivores() {
        return carnivores;
    }

    public void setCarnivores(List<Carnivore> carnivores) {
        this.carnivores = carnivores;
    }

    public List<Omnivore> getOmnivores() {
        return omnivores;
    }

    public void setOmnivores(List<Omnivore> omnivores) {
        this.omnivores = omnivores;
    }

    public List<Herbivore> getHerbivores() {
        return herbivores;
    }

    public void setHerbivores(List<Herbivore> herbivores) {
        this.herbivores = herbivores;
    }

    public int getPlantCount() {
        return plants.size();
    }

    public int getAnimalCount() {
        return animals.size();
    }

    public void addAnimal(Animal animal){
        if(!animals.equals(animal)) {
            animals.add(animal);
            if(animal instanceof Omnivore){
                omnivores.add((Omnivore) animal);
            } else if(animal instanceof Herbivore){
                herbivores.add((Herbivore) animal);
            } else {
                carnivores.add((Carnivore) animal);
            }
        }
    }

    public void addPlant(Plant plant){
        if (!plants.equals(plant)) {
            plants.add(plant);
        }
    }


    public void printNoteBook(){
        animals.stream().forEach(System.out::println);
        plants.forEach(System.out :: println);
    }

    public void sortAllAnimalsByName(){
        animals.sort(Comparator.comparing(Animal::getName));
        animals.forEach(System.out::println);
    }

    public void sortAllPlantsByName(){
        plants.sort(Comparator.comparing(Plant::getName));
        plants.forEach(System.out::println);
    }

    public void printHeavyAnimalsCount(){
        Map<Object, Long> countH = herbivores.stream().collect(Collectors.groupingBy(e -> e.getWeight()>50, Collectors.counting()));
        System.out.println("There are this many herbivores over 50 kg: " +countH);

        Map<Object, Long> countC = carnivores.stream().collect(Collectors.groupingBy(e -> e.getWeight()>50, Collectors.counting()));
        System.out.println("There are this many carnivores over 50 kg: " +countC);

        Map<Object, Long> countO = omnivores.stream().collect(Collectors.groupingBy(e -> e.getWeight()>50, Collectors.counting()));
        System.out.println("There are this many omnivores over 50 kg: " +countO);
        }

    public void printTallAnimals(){
        animals.stream().filter((e)-> {
            if (e.getHeight() > 100){
                return true;
            }
            return false;
        }).forEach(System.out::println);
    }

    public void sortAllAnimalsByHeight(){
        animals.sort(Comparator.comparing(Animal::getHeight));
        animals.forEach(System.out::println);
    }

    public void sortAllPlantsByHeight(){
        plants.sort(Comparator.comparing(Plant::getHeight));
        plants.forEach(System.out::println);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ForestNoteBook that = (ForestNoteBook) o;
        return plantCount == that.plantCount &&
                animalCount == that.animalCount &&
                Objects.equals(carnivores, that.carnivores) &&
                Objects.equals(omnivores, that.omnivores) &&
                Objects.equals(herbivores, that.herbivores) &&
                Objects.equals(animals, that.animals) &&
                Objects.equals(plants, that.plants);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carnivores, omnivores, herbivores, plantCount, animalCount, animals, plants);
    }
}
