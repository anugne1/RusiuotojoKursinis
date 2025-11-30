
package com.example.rusiuotojokursinis;
public class Deze extends GameObject {
    private final char tipas;

    public Deze(char tipas) {
        this.tipas = tipas;
        this.name = "Deze - " + tipas;
    }

    public char getTipas() {
        return tipas;
    }

    @Override
    public void update() {
        System.out.println("|*|");
    }
}
