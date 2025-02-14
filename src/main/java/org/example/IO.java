package org.example;

import org.example.inventory.Computer;
import org.example.inventory.Table;
import org.example.inventory.Thing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.example.animals.*;

import java.util.Scanner;

@Component
public class IO {
    private final Zoo zoo;

    @Autowired // Внедряем Zoo через конструктор
    public IO(Zoo zoo) {
        this.zoo = zoo;
    }

    void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Choose you action: \n1. Add an animal \n2. Add a thing" +
                    "\n3. Get a report on the required amount of food  \n4. Get interactive animals" +
                    "\n5. Get data about all the animals \n6. Get data about all the things");
            int reply = scanner.nextInt();
            switch (reply) {
                case 1:
                    addAnimal(scanner);
                    break;
                case 2:
                    addThing(scanner);
                    break;
                case 3:
                    System.out.println(zoo.totalFood() + " required");
                    break;
                case 4:
                    zoo.printInteractiveAnimals();
                    break;
                case 5:
                    zoo.printAnimals();
                    break;
                case 6:
                    zoo.printInventory();
                    break;
                default:
                    System.out.println("Try again");
            }
        }
    }

    private void addAnimal(Scanner scanner) {
        System.out.println("Choose the type of animal: \n1. Monkey \n2. Rabbit \n3. Wolf \n4. Tiger");
        int animalType = scanner.nextInt();

        System.out.println("Enter the animal's number:");
        int number = scanner.nextInt(), kindness;

        Animal animal = null;
        switch (animalType) {
            case 1:
                System.out.println("Enter the animal's kindness:");
                kindness = scanner.nextInt();
                animal = new Monkey(number, kindness);
                break;
            case 2:
                System.out.println("Enter the animal's kindness:");
                kindness = scanner.nextInt();
                animal = new Rabbit(number, kindness);
                break;
            case 3:
                animal = new Wolf(number);
                break;
            case 4:
                animal = new Tiger(number);
                break;
            default:
                System.out.println("Invalid animal type.");
                return;
        }
        zoo.addAnimal(animal);
        System.out.println("Animal added.");
    }

    private void addThing(Scanner scanner) {
        System.out.println("Choose the type of thing: \n1. Table \n2. Computer");
        int thingType = scanner.nextInt();

        System.out.println("Enter the thing's number:");
        int number = scanner.nextInt();

        Thing thing = null;
        switch (thingType) {
            case 1:
                thing = new Table(number);
                break;
            case 2:
                thing = new Computer(number);
                break;
            default:
                System.out.println("Invalid thing type.");
                return;
        }

        zoo.addThing(thing);
        System.out.println("Thing added.");
    }
}