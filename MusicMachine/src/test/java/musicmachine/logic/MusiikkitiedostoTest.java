package musicmachine.logic;

import java.io.File;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MusiikkitiedostoTest {

    public MusiikkitiedostoTest() {
    }

    Musiikkitiedosto musiikkitiedosto;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        File tiedosto = new File("audio/Juna_kulkee.mid");
        musiikkitiedosto = new Musiikkitiedosto(tiedosto);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void tiedostonimiToimii() {
        assertEquals("aaa", musiikkitiedosto.getTiedostopolku());
    }

    @Test
    public void kestoToimiiAsetettuna() {
        musiikkitiedosto.setKesto(180);
        assertEquals(180, musiikkitiedosto.getKesto());
    }

    @Test
    public void tiedostonimenAsetusToimii() {
        musiikkitiedosto.setTiedostopolku("bbb");
        assertEquals("bbb", musiikkitiedosto.getTiedostopolku());
    }

    @Test
    public void kestoToimiiOletuksella() {
        assertEquals(0, musiikkitiedosto.getKesto());
    }
}
