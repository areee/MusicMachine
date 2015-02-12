package musicmachine.logic;

import java.io.*;
import javax.sound.sampled.*;
import sun.audio.*;

/**
 * Luokka hoitaa MusicMachinen musiikkitiedostojen toistot, lisäämiset ja
 * poistot
 */
public class Sovelluslogiikka {

    private Musiikkitiedosto musiikkitiedosto;
//    private InputStream input;
//    private AudioStream audioStream;

    private Clip klippi;
    private AudioInputStream audioInputStream;

    /**
     * Metodi asettaa musiikkitiedoston audioStreamiin
     *
     * @param merkkijono käyttäjän antama syöte
     * @throws java.io.IOException
     * @throws javax.sound.sampled.LineUnavailableException
     * @throws javax.sound.sampled.UnsupportedAudioFileException
     */
    public void valitseTiedosto(String merkkijono) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        musiikkitiedosto = new Musiikkitiedosto(merkkijono);
//        input = new FileInputStream(musiikkitiedosto.getTiedosto());
//        audioStream = new AudioStream(input);

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
//        AudioPlayer.player.start(audioStream);
        klippi.start();
    }

    /**
     * Metodi asettaa musiikkitiedoston tauolle
     */
    public void tauko() {
//        AudioPlayer.player.stop(audioStream);
        klippi.stop();
    }

    /**
     * Metodi lopettaa musiikkitiedoston toistamisen
     *
     * @throws java.io.IOException
     */
    public void lopeta() throws IOException {
//        AudioPlayer.player.stop(audioStream);
//        audioStream.close();
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
     * @return musiikkitiedoston kesto bitteinä(?)
     */
    public int kesto() { // aikayksikkö vielä epäselvä
        AudioFormat format = audioInputStream.getFormat();
        long frames = audioInputStream.getFrameLength();
        return (int) ((frames + 0.0) / format.getFrameRate());
//        return musiikkitiedosto.getTiedosto().getTotalSpace();
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
//        return audioStream.available();
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
     * Metodi palauttaa InputStreamin arvon
     *
     * @return input
     */
//    public InputStream getInput() {
//        return input;
//    }
    /**
     * Metodi asettaa InputStreamin
     *
     * @param input
     */
//    public void setInput(InputStream input) {
//        this.input = input;
//    }
    /**
     * Metodi palauttaa AudioStreamin arvon
     *
     * @return audioStream
     */
//    public AudioStream getAudioStream() {
//        return audioStream;
//    }
    /**
     * Metodi asettaa AudioStreamin
     *
     * @param audioStream
     */
//    public void setAudioStream(AudioStream audioStream) {
//        this.audioStream = audioStream;
//    }
    /**
     * Metodi kelaa kappaletta 50 bittiä eteenpäin
     *
     * @throws IOException
     * @throws javax.sound.sampled.LineUnavailableException
     */
    public void kelaaEteenpain() throws IOException, LineUnavailableException {
        tauko();
//        input.
        audioInputStream.skip(50);
//        audioStream.skip(50);
        toista();
    }

    /**
     * Metodi kelaa kappaletta 50 bittiä eteenpäin (ei toimi vielä oikein...)
     *
     * @throws IOException
     * @throws javax.sound.sampled.LineUnavailableException
     */
    public void kelaaTaaksepain() throws IOException, LineUnavailableException {
        tauko();
        audioInputStream.skip(-50);
//        audioStream.skip(-50);
        toista();
    }
}
