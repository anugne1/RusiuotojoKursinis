package com.example.rusiuotojokursinis;

public class Konvejeris {

    private final DezeFactory factory = new RandomDezeFactory();

    public Deze sugeneruotiDeze() {
        return factory.sukurti();
    }

    public void rodytiKritima(Deze deze) {
        try {
            for (int i = 0; i < 8; i++) {
                deze.update();
                Thread.sleep(Constants.KRITIMO_GREITIS_MS);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("[" + deze.getTipas() + "] pasiekė sklendę!");
    }
}
