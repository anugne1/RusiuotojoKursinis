package com.example.rusiuotojokursinis;

import java.util.Random;

//factory method implementacija
public class RandomDezeFactory implements DezeFactory {

    private final Random random = new Random();

    @Override //per interfeisa gaunasi naudoju
    public Deze sukurti() {
        int r = random.nextInt(3);
        return switch (r) {
            case 0 -> new DezeA();
            case 1 -> new DezeB();
            default -> new DezeC();
        };
    }
}
