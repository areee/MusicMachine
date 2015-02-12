package musicmachine.logic;

import java.io.FileInputStream;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sun.audio.AudioStream;

public class SovelluslogiikkaTest {

    private Sovelluslogiikka sovelluslogiikka;
    private final String testipolku;

    public SovelluslogiikkaTest() {
        testipolku = "audio/Juna_kulkee.mid";
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws IOException {
        sovelluslogiikka = new Sovelluslogiikka();
        sovelluslogiikka.valitseTiedosto(testipolku);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void saaTiedostonimen() throws IOException {
        assertEquals(testipolku, sovelluslogiikka.tiedostopolku());
    }

    @Test
    public void testaaKesto() throws IOException {
        assertEquals(15523200, sovelluslogiikka.kesto());
    }

    @Test
    public void sovelluslogiikanMusiikkitiedostoToimii() throws IOException {
        Musiikkitiedosto musiikkitiedosto = sovelluslogiikka.getMusiikkitiedosto();
        assertEquals(testipolku, musiikkitiedosto.getTiedosto());
    }

    @Test
    public void audioStreamienLukuJaKirjoitusSamat() throws IOException {
        AudioStream audioStream = new AudioStream(new FileInputStream(testipolku));
        sovelluslogiikka.setAudioStream(audioStream);

        assertEquals(audioStream, sovelluslogiikka.getAudioStream());
    }

    @Test
    public void fileInputStreamienLukuJaKirjoitusSamat() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(testipolku);
        sovelluslogiikka.setInput(fileInputStream);

        assertEquals(fileInputStream, sovelluslogiikka.getInput());
    }
}
