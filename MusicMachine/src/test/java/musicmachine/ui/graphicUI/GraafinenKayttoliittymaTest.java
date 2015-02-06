package musicmachine.ui.graphicUI;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class GraafinenKayttoliittymaTest {

    private GraafinenKayttoliittyma gk;

    public GraafinenKayttoliittymaTest() {
        gk = new GraafinenKayttoliittyma();
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void pienennaIndeksiaYhdella() {
        gk.setIndeksi(5);
        gk.pienennaIndeksiaYhdella(5);
        assertEquals(4, gk.getIndeksi());
    }

    @Test
    public void pienennaIndeksiaYhdellaKokoEri() {
        gk.setIndeksi(5);
        gk.pienennaIndeksiaYhdella(4);
        assertEquals(5, gk.getIndeksi());
    }

    @Test
    public void tiedostoEiAsetettu() {
        assertFalse(gk.isTiedostoAsetettu());
    }

    @Test
    public void tiedostoOnAsetettu() {
        gk.setTiedostoAsetettu(true);
        assertTrue(gk.isTiedostoAsetettu());
    }
    
    @Test
    public void tiedostoEiValittu() {
        assertFalse(gk.isTiedostoValittu());
    }

    @Test
    public void tiedostoOnValittu() {
        gk.setTiedostoValittu(true);
        assertTrue(gk.isTiedostoValittu());
    }
    
    @Test
    public void tiedostoEiToisteta() {
        assertFalse(gk.isTiedostoaToistetaan());
    }

    @Test
    public void tiedostoaToistetaan() {
        gk.setTiedostoaToistetaan(true);
        assertTrue(gk.isTiedostoaToistetaan());
    }
}
