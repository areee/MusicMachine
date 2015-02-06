package musicmachine.ui.textUI;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TekstiKayttoliittymaTest {

    public TekstiKayttoliittymaTest() {
    }
    private TekstiKayttoliittyma tk;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        tk = new TekstiKayttoliittyma();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testaaSulkeutuukoOhjelma() {
        assertEquals("Ohjelma sulkeutuu.", tk.suljeOhjelma());
    }

    @Test
    public void taukoTulostuu() {
        assertEquals("Tauko\n", tk.asetaMusiikkiTauolle());
    }

    @Test
    public void lopetaToistoTulostuu() {
        assertEquals("Toisto lopetettu.", tk.lopetaToisto());
    }

    @Test
    public void ohjeTulostuu() {
        assertEquals("Anna tiedostonimi muodossa\n"
                + "\"/Users/ylhaart/Music/Elastinen_Eteen ja ylos.wav\"\n"
                + "tai \"/Users/ylhaart/Music/Rally_3D_title_music.mid\"", tk.ohje());
    }

    @Test
    public void virheTulostuu() {
        assertEquals("Virhe! Et ole valinnut musiikkitiedostoa toistettavaksi.", tk.tiedostoaEiVoidaToistaa());
    }

    @Test
    public void toistetaanTulostuu () {
        assertEquals("Toistetaan...", tk.toistaMusiikkia());
    }

}