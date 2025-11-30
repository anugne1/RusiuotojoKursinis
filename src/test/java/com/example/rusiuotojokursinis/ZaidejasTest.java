package com.example.rusiuotojokursinis;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ZaidejasTest {

    @Test
    public void testTeisingaSklendePridedaTaskus() {
        Zaidejas z = new Zaidejas();
        z.keistiSklende(1); // A

        Deze deze = new Deze('A');

        z.tikrintiSklende(deze);

        assertEquals(10, z.getTaskai());
    }

    @Test
    public void testNeteisingaSklendeAtimaGyvybe() {
        Zaidejas z = new Zaidejas();
        z.keistiSklende(1);

        Deze deze = new Deze('C');

        z.tikrintiSklende(deze);

        assertEquals(2, z.getGyvybes());
    }

    @Test
    public void testComboVeikia() {
        Zaidejas z = new Zaidejas();
        z.keistiSklende(1);

        Deze deze = new Deze('A');

        z.tikrintiSklende(deze);
        z.tikrintiSklende(deze);
        z.tikrintiSklende(deze);

        assertEquals(40, z.getTaskai());
    }

    @Test
    public void testComboZinute() {
        ComboStrategija s = new ComboStrategija();

        s.skaiciuotiTaskus(true);
        s.skaiciuotiTaskus(true);
        s.skaiciuotiTaskus(true);

        assertEquals("COMBO BONUS", s.gautiZinute());
    }

    @Test
    public void testSklendesKeitimas() {
        Zaidejas z = new Zaidejas();

        z.keistiSklende(3);

        assertEquals(3, z.getSklendesPadetis());
    }

    @Test
    public void testComboResetPoKlaidos() {
        ComboStrategija s = new ComboStrategija();

        s.skaiciuotiTaskus(true);
        s.skaiciuotiTaskus(true);

        s.skaiciuotiTaskus(false);

        int t = s.skaiciuotiTaskus(true);

        assertEquals(10, t);
    }

    @Test
    public void testKonvejerisSugeneruojaDeze() {
        Konvejeris k = new Konvejeris();
        Deze d = k.sugeneruotiDeze();

        assertNotNull(d);
    }

    @Test
    public void testDezesTipasValidus() {
        Konvejeris k = new Konvejeris();
        Deze d = k.sugeneruotiDeze();

        char t = d.getTipas();
        assertTrue(t == 'A' || t == 'B' || t == 'C');
    }



}
