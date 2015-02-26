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
    private boolean tiedostoAsetettu = false;
    private boolean tiedostoValittu = false;
    private boolean tiedostoaToistetaan = false;
    private boolean luuppausPaalla = false;

    private int aanitiedostonKesto;
    private int aanenSijainti = 0;

    /**
     * Metodi asettaa äänitiedoston toistovalmiiksi
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

            klippi = (Clip) AudioSystem.getLine(info);

            klippi.open(audioInputStream);
        } finally {
            audioInputStream.close();
        }
        aanitiedostonKesto = (int) (klippi.getMicrosecondLength() / 1000);
    }

    /**
     * Metodi laittaa äänitiedoston soimaan
     *
     * @throws javax.sound.sampled.LineUnavailableException
     * @throws java.io.IOException
     */
    public void toista() throws LineUnavailableException, IOException {
        klippi.start();
    }

    /**
     * Metodi asettaa äänitiedoston tauolle
     */
    public void tauko() {
        klippi.stop();
    }

    /**
     * Metodi lopettaa äänitiedoston toistamisen
     *
     * @throws java.io.IOException
     */
    public void lopeta() throws IOException {
        klippi.close();
    }

    /**
     * Metodi palauttaa äänitiedoston tiedostopolun
     *
     * @return äänitiedoston tiedostopolku
     */
    public String tiedostopolku() {
        return this.musiikkitiedosto.getTiedosto().getAbsolutePath();
    }

    /**
     * Metodi palauttaa keston minuutteina ja sekunteina
     *
     * @param kestoSekunteina
     * @return äänitiedoston kesto minuutteina ja sekunteina
     */
    public String kestoMinuutteinaJaSekunteina(int kestoSekunteina) {
        String palautettavaArvo = "";

        if (kestoSekunteina >= 60) {

            int minuutit = kestoSekunteina / 60;
            int sekunnit = kestoSekunteina % 60;

            if (minuutit < 10) {
                palautettavaArvo += "0" + minuutit;
            } else {
                palautettavaArvo += minuutit;
            }
            if (sekunnit < 10) {
                palautettavaArvo += ":0" + sekunnit;
            } else {
                palautettavaArvo += ":" + sekunnit;
            }

        } else if (kestoSekunteina < 10) {
            palautettavaArvo += "00:0" + kestoSekunteina;
        } else {
            palautettavaArvo += "00:" + kestoSekunteina;
        }
        return palautettavaArvo;
    }

    /**
     * Metodi palauttaa äänitiedoston keston
     *
     * @return aanitiedostonKesto
     */
    public int getAanitiedostonKesto() {
        return aanitiedostonKesto;
    }

    /**
     * Metodi palauttaa äänitiedoston nykyisen sijainnin
     *
     * @return aanenSijainti
     */
    public int getAanenSijainti() {
        return aanenSijainti;
    }

    /**
     * Metodi asettaa äänitiedostolle uuden sijainnin
     *
     * @param aanenSijainti
     */
    public void setAanenSijainti(int aanenSijainti) {
        this.aanenSijainti = aanenSijainti;
    }

    /**
     * Metodi palauttaa äänitiedoston keston sekunteina
     *
     * @return äänitiedoston kesto sekunteina
     */
    public int kestoSekunteina() {
        return aanitiedostonKesto / 1000;
    }

    /**
     * Metodi palauttaa äänitiedoston toistokohdan sekunteina
     *
     * @return tiedoston toistokohta sekunteina (ei toimi vielä...)
     * @throws IOException
     */
    public int tiedostonToistokohtaSekunteina() throws IOException {
        return (int) klippi.getMicrosecondPosition() / 1000000;
    }

    /**
     * Metodi palauttaa äänitiedoston tiedostonimen
     *
     * @return tiedostonimi
     */
    public String tiedostonimi() {
        return musiikkitiedosto.getTiedosto().getName();
    }

    /**
     * Metodi palauttaa äänitiedoston
     *
     * @return musiikkitiedosto
     */
    public Musiikkitiedosto getMusiikkitiedosto() {
        return musiikkitiedosto;
    }

    /**
     * Metodi asettaa äänitiedoston
     *
     * @param musiikkitiedosto
     */
    public void setMusiikkitiedosto(Musiikkitiedosto musiikkitiedosto) {
        this.musiikkitiedosto = musiikkitiedosto;
    }

    /**
     * Metodi asettaa musiikkikappaleen toistokohdan halutuksi
     *
     * @param sijainti
     */
    public void asetaToistokohta(int sijainti) {
        if (sijainti < 0 || sijainti > aanitiedostonKesto) {
            return;
        }
        aanenSijainti = sijainti;
        klippi.setMicrosecondPosition(sijainti * 1000);
    }

    /**
     * Metodi palauttaa, onko tiedosto asetettu (true tai false)
     *
     * @return tiedostoAsetettu
     */
    public boolean isTiedostoAsetettu() {
        return tiedostoAsetettu;
    }

    /**
     * Metodi muuttaa tiedostoAsetettu-muuttujan boolean-arvoa
     *
     * @param tiedostoAsetettu
     */
    public void setTiedostoAsetettu(boolean tiedostoAsetettu) {
        this.tiedostoAsetettu = tiedostoAsetettu;
    }

    /**
     * Metodi palauttaa, onko tiedosto valittu (true tai false)
     *
     * @return tiedostoAsetettu
     */
    public boolean isTiedostoValittu() {
        return tiedostoValittu;
    }

    /**
     * Metodi muuttaa tiedostoValittu-muuttujan boolean-arvoa
     *
     * @param tiedostoValittu
     */
    public void setTiedostoValittu(boolean tiedostoValittu) {
        this.tiedostoValittu = tiedostoValittu;
    }

    /**
     * Metodi palauttaa, toistetaanko tiedostoa (true tai false)
     *
     * @return tiedostoAsetettu
     */
    public boolean isTiedostoaToistetaan() {
        return tiedostoaToistetaan;
    }

    /**
     * Metodi muuttaa tiedostoaToistetaan-muuttujan boolean-arvoa
     *
     * @param tiedostoaToistetaan
     */
    public void setTiedostoaToistetaan(boolean tiedostoaToistetaan) {
        this.tiedostoaToistetaan = tiedostoaToistetaan;
    }

    /**
     * Metodi palauttaa, onko luuppaus päällä (true tai false)
     *
     * @return tiedostoAsetettu
     */
    public boolean isLuuppausPaalla() {
        return luuppausPaalla;
    }

    /**
     * Metodi muuttaa luuppausPaalla-muuttujan boolean-arvoa
     *
     * @param luuppausPaalla
     */
    public void setLuuppausPaalla(boolean luuppausPaalla) {
        this.luuppausPaalla = luuppausPaalla;
    }

    /**
     * Metodi palauttaa, onko klippi aktiivinen (true tai false)
     *
     * @return tiedostoAsetettu
     */
    public boolean onkoKlippiAktiivinen() {
        return klippi.isActive();
    }

    /**
     * Metodi päivittää tiedoston toistokohtaa
     */
    public void tiedostonToistokohdanPaivittyminen() {
        aanenSijainti = (int) (klippi.getMicrosecondPosition() / 1000);
    }

    /**
     * Metodi nollaa, eli asettaa klipin toistokohdaksi nollan
     */
    public void nollaaKlippi() {
        klippi.setMicrosecondPosition(0);
    }
}
