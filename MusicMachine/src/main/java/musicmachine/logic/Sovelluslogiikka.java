package musicmachine.logic;

import java.io.*;
import javax.sound.sampled.*;

/**
 * Luokka hoitaa MusicMachinen musiikkitiedostojen toistot, lisäämiset ja
 * poistot
 */
public class Sovelluslogiikka {

    private Musiikkitiedosto musiikkitiedosto;
    private Clip klippi;
    private AudioInputStream audioInputStream;

    /**
     * Metodi asettaa musiikkitiedoston toistovalmiuteen
     *
     * @param merkkijono käyttäjän antama syöte
     * @throws java.io.IOException
     * @throws javax.sound.sampled.LineUnavailableException
     * @throws javax.sound.sampled.UnsupportedAudioFileException
     */
    public void valitseTiedosto(String merkkijono) throws IOException,
            LineUnavailableException, UnsupportedAudioFileException {

        musiikkitiedosto = new Musiikkitiedosto(merkkijono);
        klippi = AudioSystem.getClip();
        audioInputStream = AudioSystem.getAudioInputStream(
                musiikkitiedosto.getTiedosto());
        klippi.open(audioInputStream);
    }

    /**
     * Metodi laittaa musiikkitiedoston soimaan
     *
     * @throws javax.sound.sampled.LineUnavailableException
     * @throws java.io.IOException
     */
    public void toista() throws LineUnavailableException, IOException {
        klippi.start();
    }

    /**
     * Metodi asettaa musiikkitiedoston tauolle
     */
    public void tauko() {
        klippi.stop();
    }

    /**
     * Metodi lopettaa musiikkitiedoston toistamisen
     *
     * @throws java.io.IOException
     */
    public void lopeta() throws IOException {
        klippi.close();
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
     * @return musiikkitiedoston kesto sekunteina
     */
    public int kestoSekunteina() {
        AudioFormat format = audioInputStream.getFormat();
        long frames = audioInputStream.getFrameLength();
        return (int) ((frames + 0.0) / format.getFrameRate());
    }

    /**
     * Metodi palauttaa musiikkitiedoston toistokohdan
     *
     * @return tiedoston toistokohta sekunteina (ei toimi vielä...)
     * @throws IOException
     */
    public int tiedostonToistokohta() throws IOException {
        return 0;
    }

    public String tiedostonimi() {
        return musiikkitiedosto.getTiedosto().getName();
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
     * Metodi kelaa kappaletta 50 bittiä eteenpäin
     *
     * @throws IOException
     * @throws javax.sound.sampled.LineUnavailableException
     */
    public void kelaaEteenpain() throws IOException, LineUnavailableException {
        tauko();
        audioInputStream.skip(100000);
        toista();
    }

    /**
     * Metodi kelaa kappaletta 50 bittiä taaksepäin (ei toimi vielä oikein...)
     *
     * @throws IOException
     * @throws javax.sound.sampled.LineUnavailableException
     */
    public void kelaaTaaksepain() throws IOException, LineUnavailableException {
        tauko();
        audioInputStream.skip(-100000);
        toista();
    }
}
