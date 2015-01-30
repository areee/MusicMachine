package musicmachine.logic;

import java.io.*;
import sun.audio.*;

public class Sovelluslogiikka {

    private Musiikkitiedosto musiikkitiedosto;
    private InputStream input;
    private AudioStream audioStream;

    public void valitseTiedosto(String komento) throws IOException {
        musiikkitiedosto = new Musiikkitiedosto(komento);
        input = new FileInputStream(musiikkitiedosto.getTiedostopolku());
        audioStream = new AudioStream(input);
    }

    public void toista() {
        AudioPlayer.player.start(audioStream);
    }

    public void tauko() {
        AudioPlayer.player.stop(audioStream);
    }

    public void lopeta() throws IOException {
        AudioPlayer.player.stop(audioStream);
        audioStream.close();
    }

    public String tiedostonimi() {
        return this.musiikkitiedosto.getTiedostopolku();
    }

    public int kesto() { // aikayksikkö vielä epäselvä
        return audioStream.getLength(); // /85000 (?)
    }

}
