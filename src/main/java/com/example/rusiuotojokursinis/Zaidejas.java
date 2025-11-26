package com.example.rusiuotojokursinis;

class Zaidejas {
    private int gyvybes = 3;
    private int taskai = 0;
    private int sklendesPadetis = 1;

    public int getGyvybes() {
        return gyvybes;
    }

    public int getTaskai() {
        return taskai;
    }

    public int getSklendesPadetis() {
        return sklendesPadetis;
    }                                      //getteriai

    public void keistiSklende(int numeris) {
        if (numeris >= 1 && numeris <= 3) {
            sklendesPadetis = numeris;
            System.out.println("Sklendė perjungta į " + numeris + " poziciją");
        }
    }

    public void tikrintiSklende(Deze deze) {
        char laukiamasTipas = switch (sklendesPadetis) {
            case 1 -> 'A';
            case 2 -> 'B';
            case 3 -> 'C';
            default -> '?';
        };

        if (deze.getTipas() == laukiamasTipas) {
            taskai += 10;
            System.out.println("+++Teisingai! +10 taškų.");
        } else {
            gyvybes--;
            System.out.println("---Klaida! Prarasta viena gyvybė.");
        }
    }

    public void rodytiBusena() {
        System.out.println("Taškai: " + taskai + " | Gyvybės: " + gyvybes);
    }
}
