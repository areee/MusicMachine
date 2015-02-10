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
     * @throws java.io.IOException
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
     *
     * @throws java.io.IOException
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
    public String tiedostopolku() {
        return this.musiikkitiedosto.getTiedostopolku();
    }

    /**
     * Metodi palauttaa musiikkitiedoston keston.
     *
     * @return musiikkitiedoston kesto millisekunteina(?)
     */
    public int kesto() { // aikayksikkö vielä epäselvä
        return audioStream.getLength(); // /85000 (?)
    }

    /**
     * Metodi palauttaa musiikkitiedoston toistokohdan.
     *
     * @return tiedoston toistokohta millisekunteina(?)
     * @throws IOException
     */
    public int tiedostonToistokohta() throws IOException {
        return audioStream.available();
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
     * @param musiikkitiedosto
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
     * @param input
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
     * @param audioStream
     */
    public void setAudioStream(AudioStream audioStream) {
        this.audioStream = audioStream;
    }

    /**
     * Metodi kelaa eteenpäin kappaletta 50 bittiä
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
     * Metodi kelaa taaksepäin kappaletta 50 bittiä (ei toimi vielä oikein...)
     *
     * @throws IOException
     */
    public void kelaaTaaksepain() throws IOException {
        tauko();
        audioStream.skip(-50);
        toista();
    }

    public void tallennaSoittolista() {

    }

    public void lataaSoittolista() {

    }

}
