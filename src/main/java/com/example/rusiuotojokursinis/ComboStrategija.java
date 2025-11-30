package com.example.rusiuotojokursinis;

public class ComboStrategija implements TaskuStrategija {

    private int teisinguEile = 0;
    private String zinute = "";

    @Override
    public int skaiciuotiTaskus(boolean teisinga) {

        zinute = "";

        if (teisinga) {
            teisinguEile++;

            if (teisinguEile == 3) {
                teisinguEile = 0;
                zinute = "COMBO BONUS";
                return 20;      //combo
            }

            return 10; // normalus teisingas atsakymas
        }

        teisinguEile = 0;
        return 0;
    }

    public String gautiZinute() {
        return zinute;
    }
}

