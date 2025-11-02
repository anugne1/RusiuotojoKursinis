package com.example.rusiuotojokursinis;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

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

class Deze {
    private final char tipas;

    public Deze(char tipas) {  //konstruktorius
        this.tipas = tipas;
    }

    public char getTipas() {  //sukonstravau getteri
        return tipas;
    }
}

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
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); //sustabdom o ne isjungiam
        }
        System.out.println("[" + deze.getTipas() + "] pasiekė sklendę!");
    }
}

//pagrn zaidimas cia bus
public class Rusiuotojas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Konvejeris konvejeris = new Konvejeris();
        Zaidejas zaidejas = new Zaidejas();

        System.out.println("=== RŪŠIUOTOJAS ===");
        System.out.println("Perjungimas: [1] -> A, [2] -> B, [3] -> C");
        System.out.println("Tikslas: surinkti 100 taškų prieš prarandant visas gyvybes!");
        System.out.println("--------------------------");

        AtomicBoolean veikia = new AtomicBoolean(true); //del to nes turime dvi gijas

        //gija kur laukia zaidejo ivedimo
        Thread ivestiThread = new Thread(() -> {
            while (veikia.get()) {
                String line = sc.nextLine();
                try {
                    int pasirinkimas = Integer.parseInt(line.trim());
                    zaidejas.keistiSklende(pasirinkimas);
                } catch (Exception e) {
                    System.out.println("!Netinkamas pasirinkimas!");
                }
            }
        });

        ivestiThread.start();

        //zaidimas
        while (zaidejas.getGyvybes() > 0 && zaidejas.getTaskai() < 100) {
            Deze deze = konvejeris.sugeneruotiDeze();
            System.out.println("\nNauja dėžė: " + deze.getTipas());
            konvejeris.rodytiKritima(deze);
            //ziurim ar gera sklende pasirinkta
            zaidejas.tikrintiSklende(deze);
            zaidejas.rodytiBusena();

            try {
                Thread.sleep(1500); // laikas per kuri sugeneruoja kita deze
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        veikia.set(false);
        System.out.println("\n=== ŽAIDIMO PABAIGA ===");
        if (zaidejas.getGyvybes() <= 0) {
            System.out.println("Baigėsi gyvybės!:(");
        } else {
            System.out.println("Pasiektas taškų limitas!:)");
        }

        System.out.println("Galutinis rezultatas: " + zaidejas.getTaskai() + " taškų.");
        System.out.println("Ačiū, tikiuosi patiko! ;)");

    }
}
