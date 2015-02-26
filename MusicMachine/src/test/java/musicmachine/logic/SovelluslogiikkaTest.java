package musicmachine.logic;

import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SovelluslogiikkaTest {

    private Sovelluslogiikka sovelluslogiikka;
    private String tiedostopolku;
    private String tiedostonimi;
    private String uusiTiedostopolku;
    private String uusiTiedostonimi;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws IOException, LineUnavailableException,
            UnsupportedAudioFileException {
        tiedostopolku = "audio/Juna_kulkee.mid";
        tiedostonimi = "Juna_kulkee.mid";
        uusiTiedostopolku = "audio/complete.wav";
        uusiTiedostonimi = "complete.wav";
        sovelluslogiikka = new Sovelluslogiikka();
        sovelluslogiikka.valitseTiedosto(tiedostopolku);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void tiedostonimiTasmaa() throws IOException {
        assertEquals(tiedostonimi, sovelluslogiikka.tiedostonimi());
    }

    @Test
    public void kestoTasmaa() throws IOException {
        assertEquals(145, sovelluslogiikka.kestoSekunteina());
    }

    @Test
    public void tiedostopolkuTasmaaMusiikkitiedostolla() throws IOException {
        Musiikkitiedosto musiikkitiedosto = sovelluslogiikka.getMusiikkitiedosto();
        assertEquals(System.getProperty("user.dir") + "/" + tiedostopolku,
                musiikkitiedosto.getTiedosto().getAbsolutePath());
    }

    @Test
    public void kestoTasmaaKunTiedostoVaihdettu() throws IOException,
            LineUnavailableException, UnsupportedAudioFileException {
        sovelluslogiikka.valitseTiedosto(uusiTiedostopolku);
        assertEquals(0, sovelluslogiikka.kestoSekunteina());
    }

    @Test
    public void tiedostonimiTasmaaKunTiedostoVaihdettu() throws IOException,
            LineUnavailableException, UnsupportedAudioFileException {
        sovelluslogiikka.valitseTiedosto(uusiTiedostopolku);
        assertEquals(uusiTiedostonimi, sovelluslogiikka.tiedostonimi());
    }

    @Test
    public void tiedostopolkuTasmaaKunTiedostoVaihdettu() throws IOException,
            LineUnavailableException, UnsupportedAudioFileException {
        sovelluslogiikka.valitseTiedosto(uusiTiedostopolku);
        Musiikkitiedosto musiikkitiedosto = sovelluslogiikka.getMusiikkitiedosto();
        assertEquals(System.getProperty("user.dir") + "/" + uusiTiedostopolku,
                musiikkitiedosto.getTiedosto().getAbsolutePath());
    }

    @Test
    public void luuppausEiPaalla() {
        assertFalse(sovelluslogiikka.isLuuppausPaalla());
    }

    @Test
    public void toistoEiPaalla() {
        assertFalse(sovelluslogiikka.isTiedostoaToistetaan());
    }

    @Test
    public void tiedostoaEiAsetettu() {
        assertFalse(sovelluslogiikka.isTiedostoAsetettu());
    }

    @Test
    public void tiedostoaEiValittu() {
        assertFalse(sovelluslogiikka.isTiedostoValittu());
    }

    @Test
    public void luuppausPaalla() {
        sovelluslogiikka.setLuuppausPaalla(true);
        assertTrue(sovelluslogiikka.isLuuppausPaalla());
    }

    @Test
    public void toistoPaalla() {
        sovelluslogiikka.setTiedostoaToistetaan(true);
        assertTrue(sovelluslogiikka.isTiedostoaToistetaan());
    }

    @Test
    public void tiedostoAsetettu() {
        sovelluslogiikka.setTiedostoAsetettu(true);
        assertTrue(sovelluslogiikka.isTiedostoAsetettu());
    }

    @Test
    public void tiedostoValittu() {
        sovelluslogiikka.setTiedostoValittu(true);
        assertTrue(sovelluslogiikka.isTiedostoValittu());
    }

    @Test
    public void tiedostopolkuTasmaa() {
        assertEquals(System.getProperty("user.dir") + "/" + tiedostopolku,
                sovelluslogiikka.tiedostopolku());

    }

    @Test
    public void tiedostonKestoSekunneissaTasmaa() {
        assertEquals(145, sovelluslogiikka.kestoSekunteina());
    }

    @Test
    public void tiedostonKestoMinuuteissaJaSekunneissaTasmaa() {
        assertEquals("02:25", sovelluslogiikka.kestoMinuutteinaJaSekunteina(
                sovelluslogiikka.kestoSekunteina()));
    }
}
