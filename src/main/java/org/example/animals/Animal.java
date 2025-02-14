package org.example.animals;

import org.example.interfaces.IAlive;
import org.example.interfaces.IInventory;

public abstract class Animal implements IAlive, IInventory {
    protected String name;
    protected int food;
    protected int number;

    public Animal(String name, int food, int number) {
        this.name = name;
        this.food = food;
        this.number = number;
    }

    public int getFood() {
        return food;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}