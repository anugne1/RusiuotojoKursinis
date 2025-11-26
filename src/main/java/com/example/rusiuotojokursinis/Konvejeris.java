package com.example.rusiuotojokursinis;

import java.util.Random;

class Konvejeris {
    private final Random random = new Random();

    public Deze sugeneruotiDeze() {
        char[] tipai = {'A', 'B', 'C'};
        char atsitiktinis = tipai[random.nextInt(tipai.length)];
        return new Deze(atsitiktinis);
    }

    public void rodytiKritima(Deze deze) {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("|*|");
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); //sustabdom o ne isjungiam
        }
        System.out.println("[" + deze.getTipas() + "] pasiekė sklendę!");
    }
}
