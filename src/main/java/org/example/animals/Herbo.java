package org.example.animals;

public abstract class Herbo extends Animal {
    private int kindness;

    public Herbo(String name, int food, int number, int kindness) {
        super(name, food, number);
        this.kindness = kindness;
    }

    public int getKindness() {
        return kindness;
    }
}
