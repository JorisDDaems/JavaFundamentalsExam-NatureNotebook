package be.intecbrussel.App;

import be.intecbrussel.entities.animal_entities.Carnivore;
import be.intecbrussel.entities.animal_entities.Herbivore;
import be.intecbrussel.entities.animal_entities.Omnivore;
import be.intecbrussel.entities.plant_entities.*;
import be.intecbrussel.service.ForestNoteBook;

public class NatureApp {
    public static void main(String[] args) {

        ForestNoteBook bosWandeling = new ForestNoteBook();

        Tree oak = new Tree("forest oak", LeafType.SPEAR);
        Flower rose = new Flower("yellow rose",54);
        Weed netels = new Weed("prikkers", 87);
        Bush vines = new Bush("grey vine", LeafType.HAND);
        Flower lavender = new Flower("purple lav", 65);

        bosWandeling.addPlant(oak);
        oak.setHeight(708);

        bosWandeling.addPlant(rose);
        rose.setSmell(Scent.SWEET);;

        bosWandeling.addPlant(netels);
        netels.setArea(423);

        bosWandeling.addPlant(vines);
        vines.setFruit("Strawberries");
        vines.setHeight(230);

        bosWandeling.addPlant(lavender);
        lavender.setSmell(Scent.EARTHY);


        Herbivore rabbit = new Herbivore("snuffles",3,32,34);
        Herbivore giraffe = new Herbivore("neck",870, 555,300);
        Carnivore tiger = new Carnivore("king", 750, 111, 230);
        Omnivore bear = new Omnivore("pooh", 690, 304, 304);
        Omnivore pig = new Omnivore("knorry", 130,65,90);
        Carnivore wolf = new Carnivore("snowball", 110, 54,120);
        Herbivore donkey = new Herbivore("ior", 203, 160,210);
        Herbivore koala = new Herbivore("cola", 30, 60,60);
        Carnivore crocodile = new Carnivore("snap", 78, 20,400);

        bosWandeling.addAnimal(rabbit);
        rabbit.addPlantToDiet(netels);

        bosWandeling.addAnimal(giraffe);
        giraffe.addPlantToDiet(oak);

        bosWandeling.addAnimal(tiger);
        tiger.setMaxFoodSize(260);

        bosWandeling.addAnimal(bear);
        bear.setMaxFoodSize(250);
        bear.addPlantToDiet(vines);

        bosWandeling.addAnimal(pig);
        pig.setMaxFoodSize(120);
        pig.addPlantToDiet(netels);
        pig.addPlantToDiet(lavender);

        bosWandeling.addAnimal(wolf);
        wolf.setMaxFoodSize(180);

        bosWandeling.addAnimal(donkey);
        donkey.addPlantToDiet(rose);
        donkey.addPlantToDiet(lavender);

        bosWandeling.addAnimal(koala);
        koala.addPlantToDiet(new Tree("Eucalyptus",LeafType.SPEAR));

        bosWandeling.addAnimal(crocodile);
        crocodile.setMaxFoodSize(210);

/////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("Amount of plants:" +bosWandeling.getPlantCount());
        System.out.println("Amount of animals:" +bosWandeling.getAnimalCount());
        System.out.println();
        bosWandeling.printNoteBook();
        System.out.println();

        System.out.println(bosWandeling.getCarnivores());
        System.out.println();
        System.out.println(bosWandeling.getHerbivores());
        System.out.println();
        System.out.println(bosWandeling.getOmnivores());
        System.out.println();

        bosWandeling.sortAllAnimalsByName();
        System.out.println();

        bosWandeling.sortAllPlantsByName();
        System.out.println();


        bosWandeling.printNoteBook();
        System.out.println();
    }
}
