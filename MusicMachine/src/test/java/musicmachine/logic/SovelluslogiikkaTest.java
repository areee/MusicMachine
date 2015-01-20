package musicmachine.logic;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SovelluslogiikkaTest {

    Scanner lukija;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    public SovelluslogiikkaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        lukija = new Scanner(System.in);
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void tearDown() {
        System.setOut(null);
    }

    // ei toimi!
//    @Test
//    public void ykkonenKehoittaaValitsemaanMusiikkitiedoston() {
//        Sovelluslogiikka sovelluslogiikka = new Sovelluslogiikka();
//        sovelluslogiikka.kaynnista(lukija);
//
////        String komento = lukija.nextLine();
////        String komento = "1";
////        System.out.print("Valitse toistettava musiikkitiedosto");
//        assertEquals("Valitse toistettava musiikkitiedosto", outContent.toString());
//    }
}
