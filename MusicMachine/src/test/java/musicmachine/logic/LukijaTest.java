package musicmachine.logic;

import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class LukijaTest {

    Lukija lukija;

    public LukijaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        lukija = new Lukija();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void asetaScannerToimii() {
        lukija.setLukija(new Scanner("aaa"));
        assertEquals("aaa", lukija.annaKomento());
    }

    @Test
    public void ScannerinAsetusJaLukuToimii() {
        Scanner scanner = new Scanner("aaa");
        lukija.setLukija(scanner);
        assertEquals(scanner, lukija.getLukija());
    }

    @Test
    public void lukijanKirjoitakohtaToimii() {
        assertEquals("> ", lukija.toString());
    }

}
