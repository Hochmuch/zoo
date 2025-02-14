package org.example.services;

import org.example.animals.Animal;

public class VetClinic {
    public boolean checkHealth(Animal animal) {
        return Math.random() > 0.1;
    }
}
