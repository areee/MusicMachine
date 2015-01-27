package musicmachine.logic;

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
        musiikkitiedosto = new Musiikkitiedosto("aaa");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getTiedostoToimii() {
        assertEquals("aaa", musiikkitiedosto.getTiedostopolku());
    }

    @Test
    public void setTiedostoToimii() {
        musiikkitiedosto.setTiedostopolku("bbb");
        assertEquals("bbb", musiikkitiedosto.getTiedostopolku());
    }

    @Test
    public void nollaaTiedostoToimii() {
        musiikkitiedosto.nollaaMusiikkitiedosto();
        assertEquals(null, musiikkitiedosto.getTiedostopolku());
    }

}
