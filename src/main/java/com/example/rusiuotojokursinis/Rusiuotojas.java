package com.example.rusiuotojokursinis;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

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
