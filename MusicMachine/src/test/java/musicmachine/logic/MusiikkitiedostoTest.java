package musicmachine.logic;

import java.io.File;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MusiikkitiedostoTest {

    private Musiikkitiedosto musiikkitiedosto;
    private String tiedostopolku;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        tiedostopolku = "audio/Juna_kulkee.mid";
        musiikkitiedosto = new Musiikkitiedosto(tiedostopolku);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void tiedostonimiToimii() {
        assertEquals("Juna_kulkee.mid", musiikkitiedosto.getTiedosto().getName());
    }

    @Test
    public void kestoToimiiAsetettuna() {
        musiikkitiedosto.setKesto(180);
        assertEquals(180, musiikkitiedosto.getKesto());
    }

    @Test
    public void tiedostonimenAsetusNimiOikein() {
        musiikkitiedosto.setTiedosto(new File("audio/complete.wav"));
        assertEquals("complete.wav", musiikkitiedosto.getTiedosto().getName());
    }
    
    @Test
    public void tiedostonimenAsetusKestoOikein() {
        musiikkitiedosto.setTiedosto(new File("audio/complete.wav"));
        assertEquals(0, musiikkitiedosto.getKesto());
    }

    @Test
    public void kestoToimiiOletuksella() {
        assertEquals(0, musiikkitiedosto.getKesto());
    }
}
