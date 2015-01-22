package musicmachine.ui;

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
    public void asetaMusiikkiTauolleIlmoitusToimii() {
        assertEquals("Tauko \n", tk.asetaMusiikkiTauolle());
    }

    @Test
    public void lopetaToistoIlmoitusToimii() {
        assertEquals("Toisto lopetettu.\n", tk.lopetaToisto());
    }

    @Test
    public void ohjelmanSulkeutumisIlmoitusToimii() {
        assertEquals("Ohjelma sulkeutuu.", tk.suljeOhjelma());
    }

    @Test
    public void virheIlmoitusToimii() {
        assertEquals("Virhe! Et ole valinnut musiikkitiedostoa toistettavaksi.",
                tk.tiedostoaEiVoidaToistaa());
    }

    @Test
    public void toistaMusiikkiaIlmoitusToimii() {
        assertEquals("Toistetaan... \n", tk.toistaMusiikkia());
    }

    @Test
    public void valikkotekstitToimivat() {
        assertEquals("*** MusicMachine *** \n\n"
                + "Valitse toiminto: \n"
                + "  1) Valitse toistettava musiikkitiedosto \n"
                + "  2) Toista \n"
                + "  3) Tauko \n"
                + "  4) Lopeta toisto \n"
                + "  x) Lopeta ohjelma\n", tk.valikko());
    }

    @Test
    public void valitseMusiikkitiedostoIlmoitusToimii() {
        assertEquals("Valitse toistettava musiikkitiedosto.\n"
                + "Ohje: anna tiedostonimi muodossa "
                + "\"/Users/ylhaart/Music/Disney_Classics_asennusmusa.wav\"\n"
                + "tai \"/Users/ylhaart/Music/Rally_3D_title_music.mid\"", tk.valitseMusiikkitiedosto());
    }

}
