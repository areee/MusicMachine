package musicmachine.logic;

import java.io.*;
import javax.sound.sampled.*;

/**
 * Luokka hoitaa MusicMachinen musiikkitiedostojen toistot, lisäämiset ja
 * poistot
 */
public class Sovelluslogiikka {

    private Musiikkitiedosto musiikkitiedosto;
    private Clip clip;
    private AudioInputStream audioInputStream;
    private int alkukohta;
    private int loppukohta;
    private boolean tiedostoAsetettu = false;
    private boolean tiedostoValittu = false;
    private boolean playing = false;
    private boolean luuppausPaalla = false;

    private int audioLength;
    private int audioPosition = 0;

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
        audioInputStream = AudioSystem.getAudioInputStream(
                musiikkitiedosto.getTiedosto());
        try {
            AudioFormat format = audioInputStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);

            clip = (Clip) AudioSystem.getLine(info);

            clip.open(audioInputStream);
        } finally {
            audioInputStream.close();
        }
        audioLength = (int) (clip.getMicrosecondLength() / 1000);
    }

    /**
     * Metodi laittaa musiikkitiedoston soimaan
     *
     * @throws javax.sound.sampled.LineUnavailableException
     * @throws java.io.IOException
     */
    public void toista() throws LineUnavailableException, IOException {
        clip.start();
    }

    /**
     * Metodi asettaa musiikkitiedoston tauolle
     */
    public void tauko() {
        clip.stop();
    }

    /**
     * Metodi lopettaa musiikkitiedoston toistamisen
     *
     * @throws java.io.IOException
     */
    public void lopeta() throws IOException {
        clip.close();
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
     * Metodi palauttaa keston minuutteina ja sekunteina
     *
     * @param kestoSekunteina
     * @return musiikkitiedoston kesto minuutteina ja sekunteina
     */
    public String kestoMinuutteinaJaSekunteina(int kestoSekunteina) {
        if (kestoSekunteina >= 60) {

            int minuutit = kestoSekunteina / 60;
            int sekunnit = kestoSekunteina % 60;

            return minuutit + ":" + sekunnit;

        } else if (kestoSekunteina < 10) {
            return "00:0" + kestoSekunteina;
        }

        return "00:" + kestoSekunteina;
    }

    /**
     * Metodi palauttaa musiikkitiedoston keston
     *
     * @return audioLength
     */
    public int getAudioLength() {
        return audioLength;
    }

    /**
     * Metodi palauttaa musiikkitiedoston nykyisen sijainnin
     *
     * @return audioPosition
     */
    public int getAudioPosition() {
        return audioPosition;
    }

    public void setAudioPosition(int audioPosition) {
        this.audioPosition = audioPosition;
    }

    /**
     * Metodi palauttaa musiikkitiedoston keston sekunteina
     *
     * @return musiikkitiedoston kesto sekunteina
     */
    public int kestoSekunteina() {
//        AudioFormat format = audioInputStream.getFormat();
//        long frames = audioInputStream.getFrameLength();
//         return (int) ((frames + 0.0) / format.getFrameRate());
        return audioLength / 1000;
    }

    /**
     * Metodi palauttaa musiikkitiedoston toistokohdan sekunteina
     *
     * @return tiedoston toistokohta sekunteina (ei toimi vielä...)
     * @throws IOException
     */
    public int tiedostonToistokohtaSekunteina() throws IOException {
        return (int) clip.getMicrosecondPosition() / 1000000;
    }

    /**
     * Metodi palauttaa musiikkitiedoston tiedostonimen
     *
     * @return tiedostonimi
     */
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
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    /**
     * Metodi lopettaa "luuppaamisen", eli musiikkikappaleen toiston alusta
     * uudelleen
     */
    public void lopetaLuuppaaminen() {
        clip.loop(0);
    }

    /**
     * Metodi asettaa musiikkikappaleeseen luupattavan kohdan (=
     * "musiikkikappaleen pituudenmuokkaustoiminto")
     */
    public void asetaToistokohdat() {
        clip.setLoopPoints(getAlkukohta(), getLoppukohta());
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

    /**
     * Metodi asettaa musiikkikappaleen toistokohdan halutuksi
     *
     * @param position
     */
    public int asetaToistokohta(int position) {
        if (position < 0 || position > audioLength) {
            return -1; //return
        }
        audioPosition = position;
        clip.setMicrosecondPosition(position * 1000);
        
        return position;

//        double kohtaDesimaalilukuna = kohtaProsentteina / 100;
//        double uusiToistokohta = kohtaDesimaalilukuna * kestoSekunteina() * 1000000;
//
//        klippi.stop();
//        klippi.setMicrosecondPosition((long) uusiToistokohta); // hieman epäselvää, miten toteuttaa
//        klippi.start();
//        klippi.setMicrosecondPosition(kohtaProsentteina * 1000);
    }

    public boolean isTiedostoAsetettu() {
        return tiedostoAsetettu;
    }

    public void setTiedostoAsetettu(boolean tiedostoAsetettu) {
        this.tiedostoAsetettu = tiedostoAsetettu;
    }

    public boolean isTiedostoValittu() {
        return tiedostoValittu;
    }

    public void setTiedostoValittu(boolean tiedostoValittu) {
        this.tiedostoValittu = tiedostoValittu;
    }

    public boolean isTiedostoaToistetaan() {
        return playing;
    }

    public void setTiedostoaToistetaan(boolean tiedostoaToistetaan) {
        this.playing = tiedostoaToistetaan;
    }

    public boolean isLuuppausPaalla() {
        return luuppausPaalla;
    }

    public void setLuuppausPaalla(boolean luuppausPaalla) {
        this.luuppausPaalla = luuppausPaalla;
    }

    public boolean onkoKlippiAktiivinen() {
        return clip.isActive();
    }

    public void tiedostonToistokohdanPaivittyminen() {
        audioPosition = (int) (clip.getMicrosecondPosition() / 1000);
    }

    public void nollaaKlippi() {
        clip.setMicrosecondPosition(0);
    }

}
