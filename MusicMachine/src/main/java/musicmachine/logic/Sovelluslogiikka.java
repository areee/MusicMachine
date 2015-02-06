package musicmachine.logic;

import java.io.*;
import sun.audio.*;

/**
 * Luokka hoitaa MusicMachinen musiikkitiedostojen toistot, lisäämiset ja
 * poistot.
 */
public class Sovelluslogiikka {

    private Musiikkitiedosto musiikkitiedosto;
    private InputStream input;
    private AudioStream audioStream;

    /**
     * Metodi asettaa musiikkitiedoston audioStreamiin.
     *
     * @param komento Käyttäjän antama syöte
     */
    public void valitseTiedosto(String komento) throws IOException {
        musiikkitiedosto = new Musiikkitiedosto(komento);
        input = new FileInputStream(musiikkitiedosto.getTiedostopolku());
        audioStream = new AudioStream(input);
    }

    /**
     * Metodi laittaa musiikkitiedoston soimaan.
     */
    public void toista() {
        AudioPlayer.player.start(audioStream);
    }

    /**
     * Metodi laittaa musiikkitiedoston tauolle.
     */
    public void tauko() {
        AudioPlayer.player.stop(audioStream);
    }

    /**
     * Metodi lopettaa musiikkitiedoston toistamisen.
     */
    public void lopeta() throws IOException {
        AudioPlayer.player.stop(audioStream);
        audioStream.close();
    }

    /**
     * Metodi palauttaa musiikkitiedoston tiedostopolun.
     *
     * @return musiikkitiedoston tiedostopolku
     */
    public String tiedostonimi() {
        return this.musiikkitiedosto.getTiedostopolku();
    }

    /**
     * Metodi palauttaa musiikkitiedoston keston.
     *
     * @return musiikkitiedoston kesto
     */
    public int kesto() { // aikayksikkö vielä epäselvä
        return audioStream.getLength(); // /85000 (?)
    }
    
    /**
     * Metodi palauttaa musiikkitiedoston.
     *
     * @return musiikkitiedosto
     */
    public Musiikkitiedosto getMusiikkitiedosto() {
        return musiikkitiedosto;
    }
    /**
     * Metodi asettaa musiikkitiedoston.
     *
     */
    public void setMusiikkitiedosto(Musiikkitiedosto musiikkitiedosto) {
        this.musiikkitiedosto = musiikkitiedosto;
    }
    
    /**
     * Metodi palauttaa InputStreamin arvon.
     *
     * @return input
     */
    public InputStream getInput() {
        return input;
    }
    
    /**
     * Metodi asettaa InputStreamin.
     *
     */
    public void setInput(InputStream input) {
        this.input = input;
    }
    
    /**
     * Metodi palauttaa AudioStreamin arvon.
     *
     * @return audioStream
     */
    public AudioStream getAudioStream() {
        return audioStream;
    }
    
    /**
     * Metodi asettaa AudioStreamin.
     *
     */
    public void setAudioStream(AudioStream audioStream) {
        this.audioStream = audioStream;
    }

}
