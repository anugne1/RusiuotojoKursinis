package com.example.rusiuotojokursinis;

public class Zaidejas {

    private int gyvybes = Constants.PRADINES_GYVYBES;
    private int taskai = 0;
    private int sklendesPadetis = 1;

    public int getSklendesPadetis() {
        return sklendesPadetis;
    }

    private final TaskuStrategija strategija = new ComboStrategija();


    public int getGyvybes() {
        return gyvybes;
    }

    public int getTaskai() {
        return taskai;
    }

    public void keistiSklende(int numeris) {
        if (numeris >= 1 && numeris <= 3) {
            sklendesPadetis = numeris;
            System.out.println("Sklendė perjungta į: " + numeris);
        }
    }

    public void tikrintiSklende(Deze deze) {
        boolean teisinga = false;
        char tipas = deze.getTipas();

        if (sklendesPadetis == 1 && tipas == 'A') teisinga = true;
        if (sklendesPadetis == 2 && tipas == 'B') teisinga = true;
        if (sklendesPadetis == 3 && tipas == 'C') teisinga = true;

        taskai += strategija.skaiciuotiTaskus(teisinga);
        String zinute = strategija.gautiZinute();
        if (!zinute.isEmpty()) {
            System.out.println("!" + zinute + "!");
        }

        if (!teisinga) {
            gyvybes--;
            System.out.println("---Klaida! Gyvybės: " + gyvybes);
        } else {
            System.out.println("+++Teisingai! Taškai: " + taskai);
        }
    }

}
