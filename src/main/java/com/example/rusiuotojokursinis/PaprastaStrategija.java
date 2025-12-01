package com.example.rusiuotojokursinis;

public class PaprastaStrategija implements TaskuStrategija {
    @Override
    public int skaiciuotiTaskus(boolean teisinga) {
        if (teisinga) {
            return Constants.TASKAI_UZ_TEISINGA;
        } else {
            return 0;
        }

    }

    @Override
    public String gautiZinute() {
        return "";
    }
}
