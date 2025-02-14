package org.example.inventory;

import org.example.interfaces.IInventory;

public abstract class Thing implements IInventory {
    protected String name;
    protected int number;

    public Thing(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}