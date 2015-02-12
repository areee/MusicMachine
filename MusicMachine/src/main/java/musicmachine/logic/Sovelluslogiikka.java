package musicmachine.logic;

import java.io.*;
import sun.audio.*;

/**
 * Luokka hoitaa MusicMachinen musiikkitiedostojen toistot, lisäämiset ja
 * poistot
 */
public class Sovelluslogiikka {

    private Musiikkitiedosto musiikkitiedosto;
    private InputStream input;
    private AudioStream audioStream;

    /**
     * Metodi asettaa musiikkitiedoston audioStreamiin
     *
     * @param komento Käyttäjän antama syöte
     * @throws java.io.IOException
     */
    public void valitseTiedosto(String komento) throws IOException {
        musiikkitiedosto = new Musiikkitiedosto(new File(komento));
        input = new FileInputStream(musiikkitiedosto.getTiedosto());
        audioStream = new AudioStream(input);
    }

    /**
     * Metodi laittaa musiikkitiedoston soimaan
     */
    public void toista() {
        AudioPlayer.player.start(audioStream);
    }

    /**
     * Metodi asettaa musiikkitiedoston tauolle
     */
    public void tauko() {
        AudioPlayer.player.stop(audioStream);
    }

    /**
     * Metodi lopettaa musiikkitiedoston toistamisen
     *
     * @throws java.io.IOException
     */
    public void lopeta() throws IOException {
        AudioPlayer.player.stop(audioStream);
        audioStream.close();
    }

    /**
     * Metodi palauttaa musiikkitiedoston tiedostopolun
     *
     * @return musiikkitiedoston tiedostopolku
     */
    public String tiedostopolku() {
        return this.musiikkitiedosto.getTiedosto().getAbsolutePath();
    }

    /**
     * Metodi palauttaa musiikkitiedoston keston
     *
     * @return musiikkitiedoston kesto bitteinä(?)
     */
    public long kesto() { // aikayksikkö vielä epäselvä
        return musiikkitiedosto.getTiedosto().getTotalSpace();
        // audioStream.getLength()/85000 millisekunteja(?)
    }

    /**
     * Metodi palauttaa musiikkitiedoston toistokohdan
     *
     * @return tiedoston toistokohta millisekunteina(?)
     * @throws IOException
     */
    public int tiedostonToistokohta() throws IOException {
//        musiikkitiedosto.getTiedosto().getUsableSpace();//??
        return audioStream.available();
    }

    /**
     * Metodi palauttaa musiikkitiedoston
     *
     * @return musiikkitiedosto
     */
    public Musiikkitiedosto getMusiikkitiedosto() {
        return musiikkitiedosto;
    }

    /**
     * Metodi asettaa musiikkitiedoston
     *
     * @param musiikkitiedosto
     */
    public void setMusiikkitiedosto(Musiikkitiedosto musiikkitiedosto) {
        this.musiikkitiedosto = musiikkitiedosto;
    }

    /**
     * Metodi palauttaa InputStreamin arvon
     *
     * @return input
     */
    public InputStream getInput() {
        return input;
    }

    /**
     * Metodi asettaa InputStreamin
     *
     * @param input
     */
    public void setInput(InputStream input) {
        this.input = input;
    }

    /**
     * Metodi palauttaa AudioStreamin arvon
     *
     * @return audioStream
     */
    public AudioStream getAudioStream() {
        return audioStream;
    }

    /**
     * Metodi asettaa AudioStreamin
     *
     * @param audioStream
     */
    public void setAudioStream(AudioStream audioStream) {
        this.audioStream = audioStream;
    }

    /**
     * Metodi kelaa kappaletta 50 bittiä eteenpäin
     *
     * @throws IOException
     */
    public void kelaaEteenpain() throws IOException {
        tauko();
//        input.
        audioStream.skip(50);
        toista();
    }

    /**
     * Metodi kelaa kappaletta 50 bittiä eteenpäin (ei toimi vielä oikein...)
     *
     * @throws IOException
     */
    public void kelaaTaaksepain() throws IOException {
        tauko();
        audioStream.skip(-50);
        toista();
    }
}
