package org.example;

import org.example.animals.Animal;
import org.example.animals.Herbo;
import org.example.interfaces.IInventory;
import org.example.inventory.Thing;
import org.example.services.VetClinic;


import java.util.ArrayList;
import java.util.List;

public class Zoo {
    private List<Animal> animals = new ArrayList<>();
    private List<Thing> inventory = new ArrayList<>();
    private VetClinic vetClinic;

    public Zoo(VetClinic vetClinic) {
        this.vetClinic = vetClinic;
    }

    public void addAnimal(Animal animal) {
        if (vetClinic.checkHealth(animal)) {
            animals.add(animal);
            System.out.println(animal.getName() + " accepted to the zoo.");
        } else {
            System.out.println(animal.getName() + " not accepted to the zoo.");
        }
    }

    public void addThing(Thing thing) {
        inventory.add(thing);
    }

    public int totalFood() {
        return animals.stream().mapToInt(Animal::getFood).sum();
    }

    public void printInteractiveAnimals() {
        List<Herbo> interactives = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal instanceof Herbo herbo && herbo.getKindness() > 5) {
                interactives.add(herbo);
            }
        }
        for (IInventory item : interactives) {
            System.out.println(item.getClass().getSimpleName() + ", Number " + item.getNumber());
        }
    }

    public void printInventory() {
        for (IInventory item : inventory) {
            System.out.println(item.getClass().getSimpleName() + ", Number " + item.getNumber());
        }
    }

    public void printAnimals() {
        for (IInventory item : animals) {
            System.out.println(item.getClass().getSimpleName() + ", Number " + item.getNumber());
        }
    }
}