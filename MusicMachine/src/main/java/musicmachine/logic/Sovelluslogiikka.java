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
    private int alkukohta;
    private int loppukohta;

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

    public String kestoMinuutteinaJaSekunteina() {
        int kestoSekunteina = kestoSekunteina();
        if (kestoSekunteina < 60) {
            return "00:" + kestoSekunteina;
        } else if (kestoSekunteina < 10) {
            return "00:0" + kestoSekunteina;
        }

        double minuutit = kestoSekunteina / 60; // 215/60
        int minuutitKokonaislukuna = (int) minuutit;

        double sekunnit = (minuutit - minuutitKokonaislukuna) * 60;
        int sekunnitKokonaislukuna = (int) sekunnit;
        return "" + kestoSekunteina;
//        return minuutitKokonaislukuna + ":" + sekunnitKokonaislukuna;
    }

    /**
     * Metodi palauttaa musiikkitiedoston toistokohdan
     *
     * @return tiedoston toistokohta sekunteina (ei toimi vielä...)
     * @throws IOException
     */
    public int tiedostonToistokohtaSekunteina() throws IOException {
        return (int) klippi.getMicrosecondPosition() * 1000000;
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

    /**
     * Metodi toistaa musiikkikappaleen alusta uudelleen (= "luuppaa")
     *
     * @throws javax.sound.sampled.LineUnavailableException
     * @throws java.io.IOException
     */
    public void luuppaa() throws LineUnavailableException, IOException {
        klippi.loop(Clip.LOOP_CONTINUOUSLY);
    }

    /**
     * Metodi lopettaa "luuppaamisen", eli musiikkikappaleen toiston alusta
     * uudelleen
     */
    public void lopetaLuuppaaminen() {
        klippi.loop(0);
    }

    /**
     * Metodi asettaa musiikkikappaleeseen luupattavan kohdan (=
     * "musiikkikappaleen pituudenmuokkaustoiminto")
     */
    public void asetaToistokohdat() {
        klippi.setLoopPoints(getAlkukohta(), getLoppukohta());
    }

    /**
     * Metodi palauttaa musiikkikappaleen alkukohdan
     *
     * @return alkukohta
     */
    public int getAlkukohta() {
        return alkukohta;
    }

    /**
     * Metodi asettaa musiikkikappaleen alkukohdan
     *
     * @param alkukohta
     */
    public void setAlkukohta(int alkukohta) {
        this.alkukohta = alkukohta;
    }

    /**
     * Metodi palauttaa musiikkikappaleen loppukohdan
     *
     * @return loppukohta
     */
    public int getLoppukohta() {
        return loppukohta;
    }

    /**
     * Metodi asettaa musiikkikappaleen loppukohdan
     *
     * @param loppukohta
     */
    public void setLoppukohta(int loppukohta) {
        this.loppukohta = loppukohta;
    }

    public void asetaToistokohta(int kohta) {
        kohta /= 100;
        klippi.setFramePosition(kohta * kestoSekunteina());
    }

}
