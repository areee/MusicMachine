package musicmachine.logic;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SovelluslogiikkaTest {
    
    private Sovelluslogiikka sovelluslogiikka;

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
        sovelluslogiikka = new Sovelluslogiikka();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void saaTiedostonimen() throws IOException{
        sovelluslogiikka.valitseTiedosto("/Users/ylhaart/Music/Rally_3D_title_music.mid");
        
        assertEquals("/Users/ylhaart/Music/Rally_3D_title_music.mid", sovelluslogiikka.tiedostonimi());
    }
    
    @Test
    public void testaaKesto() throws IOException{
        sovelluslogiikka.valitseTiedosto("/Users/ylhaart/Music/Rally_3D_title_music.mid");
        
        assertEquals(15523200, sovelluslogiikka.kesto());
    }
    
    
}
